package com.combanc.cas.client.springboot.dao;

import java.util.List;

/**
 * Created with Intellij IDEA
 * user a
 * @author qhl
 * Date 2018/6/4
 * Time 10:19
 */
public interface BaseDao<T> {

    /**
     * 添加操作
     * @param dto
     * @return
     */
    Integer create(T dto);

    /**
     * 修改操作
     * @param dto
     * @return
     */
    Integer update(T dto);

    /**
     * 删除操作
     * @param id
     * @return
     */
    Integer delete(Long id);

    /**
     * 删除操作
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 根据id查询单个对象记录
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 根据id查询单个对象记录
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * 查询对象集合
     * @param dto
     * @return
     */
    List<T> findByListDto(T dto);

    /**
     * 查询总条数
     * @param dto
     * @return
     */
    Integer findPgCount(T dto);

    /**
     * 分页查询所有对象
     * @param dto
     * @return
     */
    List<T> findPgList(T dto);



}
