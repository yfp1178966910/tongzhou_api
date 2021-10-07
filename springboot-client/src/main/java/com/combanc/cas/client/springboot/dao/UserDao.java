package com.combanc.cas.client.springboot.dao;

import com.combanc.cas.client.springboot.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao extends BaseDao<UserEntity>{
    int findSpecialCount(UserEntity dto);

    List<UserEntity> findSpecial(UserEntity dto);
}
