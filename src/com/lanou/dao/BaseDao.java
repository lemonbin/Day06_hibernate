package com.lanou.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/17.
 */
public interface BaseDao<T> {
    /**
     * 保存某个对象
     *
     * @param t 要保存的对象
     * @return 保存之后的对象
     */
    T save(T t);

    /**
     * 删除某个对象
     *
     * @param t 要删除的对象必须是持久化对象
     */
    void delete(T t);

    /**
     * 更新某个对象
     *
     * @param t 要更新的对象
     */
    void update(T t);

    /**
     * 查询主键对应id参数的对象
     *
     * @param id 要查询的类
     * @return 主键id
     */
    T get(Class<T> c, Serializable id);

    /**
     * 根据hq条件返回第一个符合的对象
     * @param hql 查询语句
     * @param params 查询语句中的参数列表
     * @return
     */
    T find(String hql, Map<String, Object> params);

    /**
     * 根据hql语句返回符合的结果集合
     * @param hql
     * @param params
     * @return
     */
    List<T> findAll(String hql, Map<String, Object> params);

}
