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
import java.util.List;

public class MybatisTest {



    @Test
    public void findAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();

            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            List<Student> studentList = studentDao.findAll();

            for (Student student : studentList) {
                System.out.println(student);
            }

            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
