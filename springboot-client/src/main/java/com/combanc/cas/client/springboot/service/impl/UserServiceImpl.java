package com.combanc.cas.client.springboot.service.impl;

import com.combanc.cas.client.springboot.dao.UserDao;
import com.combanc.cas.client.springboot.entity.CourseEntity;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.UserEntity;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.service.UserService;
import com.combanc.cas.client.springboot.utils.Commons;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    

    @Override
    public Result save(UserEntity dto) {
        if(dto.checkAction(ActionEnum.create)){
            int num = userDao.create(dto);
            return num > 0 ? Result.success() : Result.failed("添加失败");
        }else {
            UserEntity byId = findById(dto.getId());
            if(byId==null){return Result.failed("数据不存在");}
            if(dto.checkAction(ActionEnum.update)){
                int num = userDao.update(dto);
                return num > 0 ? Result.success() : Result.failed("修改失败");
            }else if(dto.checkAction(ActionEnum.delete)){
                int num = userDao.delete(dto.getId());
                return num > 0 ? Result.success() : Result.failed("删除失败");
            }
        }
        return Result.failed("未设置Action");
    }

    @Override
    public UserEntity findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public Result findByList(UserEntity dto) {
        List<UserEntity> list=userDao.findByListDto(dto);
        return Result.success(list);
    }

    @Override
    public PageBean<UserEntity> findByPgList(UserEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = userDao.findPgCount(dto);
        List<UserEntity> list = userDao.findPgList(dto);
        return new PageBean<>(list,count);
    }

    @Override
    public PageBean<UserEntity> findSpecial(UserEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = userDao.findSpecialCount(dto);
        List<UserEntity> list = userDao.findSpecial(dto);
        return new PageBean<>(list,count);
    }
}
