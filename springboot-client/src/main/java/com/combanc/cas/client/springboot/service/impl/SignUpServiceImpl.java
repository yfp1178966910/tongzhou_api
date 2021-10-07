package com.combanc.cas.client.springboot.service.impl;

import com.combanc.cas.client.springboot.dao.SignInDao;
import com.combanc.cas.client.springboot.dao.SignUpDao;
import com.combanc.cas.client.springboot.dao.UserDao;
import com.combanc.cas.client.springboot.entity.*;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.enums.ResultCode;
import com.combanc.cas.client.springboot.service.CourseService;
import com.combanc.cas.client.springboot.service.SignUpService;
import com.combanc.cas.client.springboot.utils.Commons;
import com.combanc.cas.client.springboot.utils.ConstantUtils;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private SignUpDao signUpDao;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserDao userDao;

    @Autowired
    private SignInDao signInDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result save(SignUpEntity dto) {
        try {
            if (dto.checkAction(ActionEnum.create)) {
                Integer pgCount = signUpDao.findPgCount(dto);
                if (pgCount > 0) {
                    return Result.failed("已报名");
                }
                //校验学生有没有其他时间上冲突的课程
                List<CourseEntity> courseEntities = signUpDao.selectCourseByUserAndCourseTime(dto);
                if (courseEntities.size() != 0) {
                    return new Result(ResultCode.VIEW_ERROR, "存在冲突课程", courseEntities);
                }

                if (addOrSubtractCourseConcurrentSignUp(dto.getCourseId(), ConstantUtils.FLAG_ADD)) {

                    String id = Commons.getIdentifier();
                    dto.setId(id);
                    int num = signUpDao.create(dto);
                    //在签到表中生成对应数据
                    CourseEntity byId = courseService.findById(dto.getCourseId());
                    //设置转换的日期格式
                    SimpleDateFormat sdf = new SimpleDateFormat(ConstantUtils.DATE_FORMAT);
                    //开始时间
                    Date startDate = sdf.parse(byId.getCourseStartDate());
                    //结束时间
                    Date endDate = sdf.parse(byId.getCourseEndDate());
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(startDate);
                    calendar.add(Calendar.DATE, -1);
                    //得到相差的天数 betweenDate
                    long betweenDate = (endDate.getTime() - startDate.getTime()) / (60 * 60 * 24 * 1000);
                    for (long i = 0; i <= betweenDate; i++) {
                        calendar.add(Calendar.DATE, 1);
                        Date concurrent = calendar.getTime();
                        SignInEntity signInEntity = new SignInEntity();

                        signInEntity.setId(Commons.getIdentifier());
                        signInEntity.setSignUpId(id);
                        signInEntity.setDate(sdf.format(concurrent));
                        signInEntity.setInStates(ConstantUtils.IN_STATES_UNDO);
                        signInEntity.setOutStates(ConstantUtils.OUT_STATES_UNDO);
                        signInEntity.setInCheckStates(ConstantUtils.IN_STATES_UNDO);
                        signInEntity.setOutCheckStates(ConstantUtils.OUT_STATES_UNDO);
                        signInEntity.setCourseId(dto.getCourseId());
                        signInEntity.setUserId(dto.getUserId());
                        signInEntity.setSignInScore(new BigDecimal(0));
                        signInDao.create(signInEntity);

                    }
                    return num > 0 ? Result.success() : Result.failed("添加失败");
                } else {
                    return Result.failed("该课程人员已满");
                }
            } else {
                SignUpEntity signUpEntity = findById(dto.getId());
                if (signUpEntity == null) {
                    return Result.failed("数据不存在");
                }
                if (dto.checkAction(ActionEnum.update)) {
                    CourseEntity courseEntity = courseService.findById(signUpEntity.getCourseId());
                    //结课状态才能评分
                    if (courseEntity == null || !ConstantUtils.COURSE_STATES_2.equals(courseEntity.getCourseStates())) {
                        return Result.failed("课程数据不存在或者为结课状态");
                    }
                    //todo  设置总量
                    int sum = dto.getScoreA() + dto.getScoreB() + dto.getScoreC() + dto.getScoreD() + dto.getScoreE();
                    if (sum < 0 || sum > 100) {
                        return Result.failed("输入评分不合法");
                    }
                    dto.setScoreSum(sum);
                    int num = signUpDao.update(dto);
                    return num > 0 ? Result.success() : Result.failed("修改失败");
                } else if (dto.checkAction(ActionEnum.delete)) {
                    //取消报名
                    CourseEntity byId = courseService.findById(signUpEntity.getCourseId());
                    if (!ConstantUtils.COURSE_STATES_0.equals(byId.getCourseStates())) {
                        return Result.failed("课程开课后不能删除报名人员");
                    }
                    int num = signUpDao.delete(dto.getId());
                    Integer numIn = signInDao.deleteBySignUpId(dto.getId());
                    addOrSubtractCourseConcurrentSignUp(signUpEntity.getCourseId(), ConstantUtils.FLAG_SUBTRACT);
                    return num > 0 || numIn > 0 ? Result.success() : Result.failed("删除失败");
                }
            }
            return Result.failed("未设置Action");

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.failed(e.getMessage());
        }
    }


    private synchronized boolean addOrSubtractCourseConcurrentSignUp(String courseId, int flag) {
        CourseEntity byId = courseService.findById(courseId);
        if (ConstantUtils.FLAG_ADD == flag) {
            if (byId.getConcurSignUp().equals(byId.getMaxSignUp())) {
                return false;
            } else if (byId.getConcurSignUp() < byId.getMaxSignUp()) {
                byId.setConcurSignUp(byId.getConcurSignUp() + 1);
                byId.setAction(ActionEnum.update.getCode());
                Result result = courseService.save(byId);
                return ResultCode.SUCCESS.getValue().equals(result.getCode());
            }
        } else if (ConstantUtils.FLAG_SUBTRACT == flag) {
            byId.setConcurSignUp(byId.getConcurSignUp() - 1);
            byId.setAction(ActionEnum.update.getCode());
            Result result = courseService.save(byId);
            return ResultCode.SUCCESS.getValue().equals(result.getCode());
        }
        return false;
    }

    @Override
    public SignUpEntity findById(String id) {
        return signUpDao.findById(id);
    }

    @Override
    public Result findByList(SignUpEntity dto) {
        List<SignUpEntity> list = signUpDao.findByListDto(dto);
        return Result.success(list);
    }

    @Override
    public PageBean<SignUpEntity> findByPgList(SignUpEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = signUpDao.findPgCount(dto);
        List<SignUpEntity> list = signUpDao.findPgList(dto);
        return new PageBean<>(list, count);
    }

    @Override
    public PageBean<Map<String, Object>> selectScoreByAdmin(SignUpEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = signUpDao.findPgCountByGroup(dto);
        List<Map<String, Object>> list = signUpDao.findPgListByGroup(dto);
        return new PageBean<>(list, count);
    }

    @Override
    public Result deleteByCourseId(String courseId) {

        int num = signUpDao.deleteByCourseId(courseId);
        return num > 0 ? Result.success() : Result.failed("删除失败");
    }

    @Override
    public PageBean<Map<String, Object>> selectGetSumByYearByUser(SignUpEntity dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        userEntity.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        dto.setOffset(userEntity.getOffset());
        dto.setLimit(userEntity.getLimit());
        int count = userDao.findPgCount(userEntity);
        List<Map<String, Object>> list = signUpDao.selectGetSumByYearByUser(dto);
        return new PageBean<>(list, count);
    }

    @Override
    public List<Map<String, Object>> selectCourseByYearAndUser(SignUpEntity dto) {
        return signUpDao.selectCourseByYearAndUser(dto);
    }


}
