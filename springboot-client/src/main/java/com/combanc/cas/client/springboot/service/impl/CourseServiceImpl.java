package com.combanc.cas.client.springboot.service.impl;

import com.combanc.cas.client.springboot.dao.CourseDao;
import com.combanc.cas.client.springboot.dao.SignInDao;
import com.combanc.cas.client.springboot.dao.SignUpDao;
import com.combanc.cas.client.springboot.entity.CourseEntity;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.SignInEntity;
import com.combanc.cas.client.springboot.entity.SignUpEntity;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.service.CourseService;
import com.combanc.cas.client.springboot.utils.Commons;
import com.combanc.cas.client.springboot.utils.ConstantUtils;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private SignInDao signInDao;
    @Autowired
    private SignUpDao signUpDao;

    @Override
    public Result save(CourseEntity dto)  {
        if(dto.checkAction(ActionEnum.create)){
            List<CourseEntity> list=courseDao.selectCourseByTimeAndClassRoom(dto);
            if(list.size()!=0)return Result.failed("当前教室存在冲突课程，请重新校验课程的时间和教室信息");
            String id= Commons.getIdentifier();
            dto.setId(id);
            dto.setIsShow("0");
            dto.setCourseStates("0");
            dto.setIsDelete(0);
            dto.setConcurSignUp(0);

            dto.setCourseCreateTime(ConstantUtils.FORMAT_DATETIME_FORMAT.format(new Date()));
            if(dto.getCourseEndDate() == null || dto.getCourseStartDate().equals(dto.getCourseEndDate())){dto.setWeeks(Commons.dateToWeek(dto.getCourseStartDate()));}
            int num = courseDao.create(dto);
            return num > 0 ? Result.success() : Result.failed("添加失败");
        }else {
            CourseEntity courseEntity = findById(dto.getId());
            if(courseEntity==null){return Result.failed("数据不存在");}
            if(dto.checkAction(ActionEnum.update)){
                if(ConstantUtils.COURSE_STATES_1.equals(courseEntity.getCourseStates()) &&
                    ConstantUtils.COURSE_STATES_2.equals(dto.getCourseStates())){
                    //课程结课后，结算学分
                    signInDao.commitSignInScore(courseEntity.getId(),ConstantUtils.UNIT_SCORE);
                    //查询所有符合条件的signIn
//                    SignInEntity signInEntity = new SignInEntity();
//                    signInEntity.setCourseId(courseEntity.getId());
                    String year = courseEntity.getCourseStartDate().substring(0,4);
//                    List<SignInEntity> unitScore = signInDao.findByListDto(signInEntity);
                    SignUpEntity signUpDto = new SignUpEntity();
                    signUpDto.setCourseId(courseEntity.getId());
                    List<SignUpEntity> signUpByListDto = signUpDao.findByListDto(signUpDto);
                    SignInEntity signInEntity = new SignInEntity();

                    for (SignUpEntity signUpUnit : signUpByListDto){
                        BigDecimal sum= new BigDecimal("0");
                        signInEntity.setSignUpId(signUpUnit.getId());
                        List<SignInEntity> unitScore = signInDao.findByListDto(signInEntity);
                        for (SignInEntity signInUnit: unitScore){
                            sum = sum.add( signInUnit.getSignInScore());
                        }
                        signUpUnit.setYear(year);
                        signUpUnit.setGetSum(sum);
                        signUpDao.update(signUpUnit);
                    }

                }
                int num = courseDao.update(dto);
                return num > 0 ? Result.success() : Result.failed("修改失败");
            }else if(dto.checkAction(ActionEnum.delete)){
                int num = courseDao.delete(dto.getId());
                return num > 0 ? Result.success() : Result.failed("删除失败");
            }
        }
        return Result.failed("未设置Action");
    }

    @Override
    public CourseEntity findById(String id) {
        return courseDao.findById(id);
    }

    @Override
    public Result findByList(CourseEntity dto) {
        List<CourseEntity> list=courseDao.findByListDto(dto);
        return Result.success(list);
    }

    @Override
    public PageBean<CourseEntity> findByPgList(CourseEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = courseDao.findPgCount(dto);
        List<CourseEntity> list = courseDao.findPgList(dto);
        return new PageBean<>(list,count);
    }

    @Override
    public Result orderByCreateTime(CourseEntity data) {
        List<CourseEntity> list=courseDao.orderByCreateTime(data);
        return Result.success(list);
    }

    @Override
    public Result orderByTeacher(CourseEntity data) {
        List<Map<String,Object>> list=courseDao.orderByTeacher(data);
        return Result.success(list);
    }

    @Override
    public Result orderByHot(CourseEntity data) {
        List<CourseEntity> list=courseDao.orderByHot(data);
        return Result.success(list);
    }

    @Override
    public Result selectCourseByTimeAndClassRoom(CourseEntity data) {
        List<CourseEntity> list=courseDao.selectCourseByTimeAndClassRoom(data);
        return Result.success(list);
    }
}
