package com.combanc.cas.client.springboot.service;

import com.combanc.cas.client.springboot.entity.UserEntity;
import com.combanc.cas.client.springboot.utils.PageBean;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends BaseService<UserEntity> {
    PageBean<UserEntity> findSpecial(UserEntity dto);
}
