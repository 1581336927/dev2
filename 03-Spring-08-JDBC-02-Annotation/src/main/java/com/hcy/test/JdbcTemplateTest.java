package com.hcy.test;

import com.hcy.config.JdbcConfig;
import com.hcy.dao.impl.JdbcTemplateDaoImpl;
import com.hcy.entity.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateTest {


    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        JdbcTemplateDaoImpl dao = context.getBean(JdbcTemplateDaoImpl.class);

        List<User> list = dao.findAll();

        System.out.println(list);
    }
}
