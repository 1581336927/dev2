package com.hcy.test;

import com.hcy.dao.StudentDao;
import com.hcy.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;

public class Mybatis_Test {


    @Test
    public void select(){
        //读取配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取链接
            SqlSession sqlSession = factory.openSession();
            //获取接口的实现类
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student student = mapper.selectId(2);
            sqlSession.commit();
            sqlSession.close();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void InsterStu(){
        //加载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取数据库连接
            SqlSession session = factory.openSession();


            StudentDao mapper = session.getMapper(StudentDao.class);

            int i = mapper.InsertStu();

            session.commit();

            session.close();

            System.out.println(i);


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
