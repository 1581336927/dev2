package com.hcy.test;


import com.hcy.dao.StudentDao;
import com.hcy.entity.Student;
import com.hcy.util.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {
    @Test
    public void findAll() {
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.findAll();

        for (Student student : studentList) {

            System.out.println(student);
        }
        MyBatisUtils.commit();
    }

    @Test
    public void findLike() {
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        List<Student> list = studentDao.keyWord("%李%", null);

        for (Student student : list) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }

    @Test
    public void findStudent() {
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        Student student1 = new Student();

        student1.setGender("男");
        student1.setAge((byte) 20);
        List<Student> studentList = studentDao.findByStudent(student1);

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void updateStudent() {
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(17);
        student.setName("韩鹏镇");
        student.setInfo("挚友");
        Integer integer = studentDao.updateStudent(student);

        MyBatisUtils.commit();
        System.out.println(integer);
    }

    @Test
    public void delete(){
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        int i = studentDao.deleteMore(7,15);

        MyBatisUtils.commit();
    }
}
