package com.combanc.cas.client.springboot.service;


import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.utils.PageBean;

import java.text.ParseException;

/**
 * Created with Intellij IDEA
 *
 * @author qhl
 * Date 2018/6/15
 * Time 13:53
 */
public interface BaseService<T> {

    /**
     * 增删改操作
     * @param dto
     * @return
     */
    Result save(T dto) ;

    /**
     * 根据id查询对象
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * 查询所有对象集合
     * @param dto
     * @return
     */
    Result findByList(T dto);

    /**
     * 分页查询所有对象集合
     * @param dto
     * @return
     */
    PageBean<T> findByPgList(T dto);
}
