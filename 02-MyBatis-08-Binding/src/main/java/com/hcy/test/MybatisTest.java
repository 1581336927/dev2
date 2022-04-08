package com.hcy.test;


import com.hcy.dao.StudentDao;
import com.hcy.dao.UserDao;
import com.hcy.entity.Student;
import com.hcy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void findByIdAndName() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();

            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            Student byIdAndName = studentDao.findByIdAndName(3, "古力娜扎");

            System.out.println(byIdAndName);

            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void findByAgeAndName() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();

            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            Student byIdAndName = studentDao.findByAgeAndName(20, "李雅文");

            System.out.println(byIdAndName);

            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void findByGenderAndName() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();

            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            Student byIdAndName = studentDao.findByGenderAndName("女", "李雅文");

            System.out.println(byIdAndName);

            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void insert() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();

            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            Map<String, Object> map = new HashMap<>();
            map.put("name", "邓紫棋");
            map.put("age", 50);
            map.put("gender", "女");
            map.put("birthday", new Date());
            map.put("info", "哈哈哈");

            Integer insert = mapper.insert(map);
            System.out.println(insert);

            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();


        }
    }

    @Test
    public void insertStudentObject() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();

            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("张飞");
            student.setAge((byte) 20);
            student.setGender("男");
            student.setBirthday(new Date());
            student.setInfo("三粗");

            Integer integer = mapper.insertStudent(student);

            System.out.println(integer);

            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();


        }
    }
}
