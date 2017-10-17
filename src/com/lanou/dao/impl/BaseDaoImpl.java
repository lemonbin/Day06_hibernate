package com.lanou.dao.impl;

import com.lanou.dao.BaseDao;
import com.lanou.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/17.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Override
    public T save(T t) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(t);// 保存对象

        transaction.commit();
        HibernateUtil.closeSession();
        return t;
    }

    @Override
    public void delete(T t) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(t);// 删除对象

        transaction.commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void update(T t) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(t);// 更新对象

        transaction.commit();
        HibernateUtil.closeSession();
    }

    @Override
    public T get(Class<T> c, Serializable id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //根据主键id进行查询
        T t = session.get(c, id);

        transaction.commit();
        HibernateUtil.closeSession();
        return t;
    }

    @Override
    public T find(String hql, Map<String, Object> params) {
        //先调用查询所有
        List<T> tList = findAll(hql, params);

        if (tList.size() > 0) {
            return tList.get(0);
        }
        return null;
    }

    @Override
    public List<T> findAll(String hql, Map<String, Object> params) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //创建hql查询语句
        Query query = session.createQuery(hql);

        //判断参数列表是否为空
        if (params != null && params.size() > 0) {
            // 遍历参数map集合
            for (String key : params.keySet()) {
                //设置条件语句中对象的参数列表
                //第一个参数对应列名, 第二个参数对应列值
                query.setParameter(key, params.get(key));
            }
        }
        //得到查询语句的集合
        List<T> tList = query.list();
        transaction.commit();
        HibernateUtil.closeSession();
        return tList;//返回查询结果集合
    }
}
