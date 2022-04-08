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
    public void findId() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession openSession = factory.openSession();

            StudentDao mapper = openSession.getMapper(StudentDao.class);

            List<Student> id = mapper.findId(3);

            for (Student student : id) {
                System.out.println(student);
            }

            openSession.commit();

            openSession.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
