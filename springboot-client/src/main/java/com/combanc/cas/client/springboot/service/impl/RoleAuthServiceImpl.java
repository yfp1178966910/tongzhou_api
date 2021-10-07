package com.combanc.cas.client.springboot.service.impl;

import com.combanc.cas.client.springboot.dao.RoleAuthDao;
import com.combanc.cas.client.springboot.dao.UserDao;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.RoleAuthEntity;
import com.combanc.cas.client.springboot.entity.UserEntity;
import com.combanc.cas.client.springboot.service.RoleAuthService;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleAuthServiceImpl implements RoleAuthService {
    @Autowired
    private RoleAuthDao roleAuthDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Result save(RoleAuthEntity dto) {

        return null;
    }

    @Override
    public RoleAuthEntity findById(String id) {
        UserEntity userEntity = userDao.findById(id);
        Integer userType = userEntity.getUserType();
        RoleAuthEntity byId = roleAuthDao.findById(userType.longValue());
        return byId;
    }

    @Override
    public Result findByList(RoleAuthEntity dto) {
        List<RoleAuthEntity> list=roleAuthDao.findByListDto(dto);
        return Result.success(list);
    }

    @Override
    public PageBean<RoleAuthEntity> findByPgList(RoleAuthEntity dto) {
       
        return null;
    }

   
}
