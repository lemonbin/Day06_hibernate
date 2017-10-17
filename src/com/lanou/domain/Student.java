package com.lanou.domain;

import java.io.Serializable;

/**
 * Created by dllo on 2017/10/17.
 */
public class Student implements Serializable{
    private Integer id;
    private String sname;
    private String gender;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String sname, String gender, Integer age) {
        this.id = id;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
    }

    public Student(String sname, String gender, Integer age) {
        this.sname = sname;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
