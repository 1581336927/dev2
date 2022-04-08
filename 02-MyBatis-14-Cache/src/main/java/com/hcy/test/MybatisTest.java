package com.hcy.test;


import com.hcy.dao.ManagerDao;
import com.hcy.dao.StudentDao;
import com.hcy.entity.Manager;
import com.hcy.entity.Student;
import com.hcy.util.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    @Test
    public void selectOne(){
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();

        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = build.openSession();

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        Student byId = mapper.findById(16);


        Student byId1 = mapper.findById(16);
        System.out.println(byId==byId1);

        sqlSession.commit();

    }
    @Test
    public void update(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = factory.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student student = new Student();
            student.setId(16);

            student.setInfo("美丽的泡沫");
            Integer stu = mapper.updateStu(student);
            Student byId = mapper.findById(15);

            System.out.println(stu);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @Test
    public void testTwo(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            System.out.println("第一次查询");
            studentDao.findById(16);
            session.commit();
            System.out.println("第二次查询");

            studentDao.findById(16);
            session.clearCache();
            System.out.println("第三次查询");
            studentDao.findById(16);
            session.commit();
            System.out.println("第四次查询");

            studentDao.findById(16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
