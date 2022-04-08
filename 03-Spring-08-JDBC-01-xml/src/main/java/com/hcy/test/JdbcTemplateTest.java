package com.hcy.test;

import com.hcy.dao.impl.JdbcTemplateDaoImpl;
import com.hcy.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplateDaoImpl dao = context.getBean(JdbcTemplateDaoImpl.class);

        List<User> list = dao.findAll();
        System.out.println(list);
    }

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplateDaoImpl dao = context.getBean(JdbcTemplateDaoImpl.class);

        User user = dao.findId(1);
        System.out.println(user);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplateDaoImpl dao = context.getBean(JdbcTemplateDaoImpl.class);

        Integer count = dao.findCount();
        System.out.println(count);
    }
}
