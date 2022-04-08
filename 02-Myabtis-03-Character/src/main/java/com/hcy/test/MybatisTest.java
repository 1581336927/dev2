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

public class MybatisTest {

    @Test
    public void  Add(){

        try {
            //加载配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建工厂类对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取数据库
            SqlSession session = factory.openSession();
            //获取接口实现类
            StudentDao mapper = session.getMapper(StudentDao.class);

            Integer integer = mapper.InsertStu();
            session.commit();
            System.out.println(integer);
            session.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @Test
    public void  Select(){

        try {
            //加载配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取数据库连接
            SqlSession session = factory.openSession();
            //创建接口实现类
            StudentDao studentDao = session.getMapper(StudentDao.class);
            //调用方法
            Student selectId = studentDao.SelectId(2);
            //提交事务
            session.commit();
            System.out.println(selectId);
            //关闭资源
            session.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
