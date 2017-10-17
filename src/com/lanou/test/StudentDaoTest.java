package com.lanou.test;

import com.lanou.dao.StudentDao;
import com.lanou.dao.impl.StudentDaoImpl;
import com.lanou.domain.Student;
import org.junit.Test;

/**
 * Created by dllo on 2017/10/17.
 */
public class StudentDaoTest {
    @Test
    public void save() {
        // 创建一个dao层的对象
        StudentDao studentDao = new StudentDaoImpl();
        // 创建要保存的对象
        Student student = new Student("光哥", "不详", 56);
        System.out.println("保存前 : " + student);
        student = studentDao.save(student);
        System.out.println("保存后 : " + student);
    }

    @Test
    public void login(){
        StudentDao studentDao = new StudentDaoImpl();
        boolean result = studentDao.login("光哥", "123456");
        System.out.println("登录结果: " +result);
    }
}
