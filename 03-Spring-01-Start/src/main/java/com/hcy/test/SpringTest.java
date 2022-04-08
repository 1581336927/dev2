package com.hcy.test;

import com.hcy.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test() {

        // 根据配置文件创建核心容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 根据配置文件中bean的id或者name获取对象
        UserDao userDao = applicationContext.getBean("userMysql", UserDao.class);


        // 调用对象的方法

        userDao.findAll();
    }
}
