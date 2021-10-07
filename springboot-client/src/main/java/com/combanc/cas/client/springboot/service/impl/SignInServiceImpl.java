package com.combanc.cas.client.springboot.service.impl;

import com.combanc.cas.client.springboot.dao.SignInDao;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.SignInEntity;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.service.SignInService;
import com.combanc.cas.client.springboot.utils.Commons;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class SignInServiceImpl implements SignInService {
    @Autowired
    private SignInDao signInDao;
    @Override
    public Result save(SignInEntity dto) {
        if(dto.checkAction(ActionEnum.create)){
            String id= Commons.getIdentifier();
            dto.setId(id);
            dto.setSignInScore(new BigDecimal(0));
//            dto.setIsShow("0");
//            dto.setCourseStates("0");
//            dto.setIsDelete(0);
//            dto.setConcurSignUp(0);
            int num = signInDao.create(dto);
            return num > 0 ? Result.success() : Result.failed("添加失败");
        }else {
            SignInEntity signInEntity = findById(dto.getId());
            if(signInEntity==null){return Result.failed("数据不存在");}
            if(dto.checkAction(ActionEnum.update)){
                int num = signInDao.update(dto);
                return num > 0 ? Result.success() : Result.failed("修改失败");
            }else if(dto.checkAction(ActionEnum.delete)){
                int num = signInDao.delete(dto.getId());
                return num > 0 ? Result.success() : Result.failed("删除失败");
            }
        }
        return Result.failed("未设置Action");
    }

    @Override
    public SignInEntity findById(String id) {
        return signInDao.findById(id);
    }

    @Override
    public Result findByList(SignInEntity dto) {
        List<SignInEntity> list = signInDao.findByListDto(dto);
        return Result.success(list);
    }

    @Override
    public PageBean<SignInEntity> findByPgList(SignInEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = signInDao.findPgCount(dto);
        List<SignInEntity> list = signInDao.findPgList(dto);
        return new PageBean<>(list, count);
    }
    @Override
    public PageBean<Map<String ,String>> findStatisticalData(SignInEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = signInDao.findStatisticalDataCount(dto);
        List<Map<String ,String>> list = signInDao.findStatisticalData(dto);
        return new PageBean<>(list, count);
    }

    @Override
   public List<Map<String ,String>> findStatisticalDataForExcel(SignInEntity dto){
        return signInDao.findStatisticalDataForExcel(dto);
   }

    @Override
    public PageBean<SignInEntity> findCheckData(SignInEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = signInDao.findCheckDataCount(dto);
        List<SignInEntity> list = signInDao.findCheckData(dto);
        return new PageBean<>(list, count);
    }

    @Override
    public Result deleteByCourseId(String courseId) {
        int num =signInDao.deleteByCourseId(courseId);
        return num > 0 ? Result.success() : Result.failed("删除失败");
    }
}
