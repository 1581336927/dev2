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

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {


    @Test
    public void select() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            UserDao dao = sqlSession.getMapper(UserDao.class);
            List<User> users = dao.selectUser();
            for (User user : users) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAge() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.selectAge(20);
            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectOne() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = build.openSession();
            StudentDao mapper = session.getMapper(StudentDao.class);
            Student student = mapper.selectStuOne(3);
            System.out.println(student);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteOne() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();

            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            Integer student = mapper.deleteStu(11);

            sqlSession.commit();

            sqlSession.close();

            System.out.println(student);


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void InsertStu() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();

            StudentDao mapper = sqlSession.getMapper(StudentDao.class);

            Integer student = mapper.InsertStu();

            sqlSession.commit();

            sqlSession.close();

            System.out.println(student);


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void updateStu() {
        //记载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取数据库连接
            SqlSession sqlSession = factory.openSession();
            //获取接口实体类对象
            StudentDao dao = sqlSession.getMapper(StudentDao.class);
            //调用方法
            Integer integer = dao.updateStu(new Student(4, "韩晨宇", (byte) 20, "男", null, "多才多艺"));
            System.out.println(integer);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void insertStu2() {
        //记载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取数据库连接
            SqlSession session = factory.openSession();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", "李雅文");
            hashMap.put("age", 20);
            hashMap.put("gender", "女");
            hashMap.put("birthday", null);
            hashMap.put("info", "富婆");
            StudentDao mapper = session.getMapper(StudentDao.class);
            Integer integer = mapper.insertStu2(hashMap);
            System.out.println(integer);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void getId() {
        //记载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取数据库连接
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> id = studentDao.getId("李");
            for (Student student : id) {
                System.out.println(student);
            }
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void selectS(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao mapper = session.getMapper(StudentDao.class);

            Student student = mapper.selectS(9);

            System.out.println(student);

            session.commit();

            session.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
