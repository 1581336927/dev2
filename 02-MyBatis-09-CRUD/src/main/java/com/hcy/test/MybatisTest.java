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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void findByKeyword() {
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        List<Student> list = studentDao.findByKeyword("%李%");

        for (Student student : list) {
            System.out.println(student);
        }

    }

    @Test
    public void getAutoIncrement() {
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("韩彭真");
        student.setAge((byte) 20);
        student.setGender("男");
        student.setBirthday(new Date());
        student.setInfo("发小");

        int i = studentDao.getAutoIncrement(student);
        Integer id = student.getId();
        System.out.println(id);
        System.out.println(i);
        MyBatisUtils.commit();
    }

}
