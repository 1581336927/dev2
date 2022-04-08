package com.hcy.test;

import com.hcy.config.MyConfig;
import com.hcy.entity.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testPerson {
    @Test
    public void test(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        User user = (User) context.getBean("getUser");

        System.out.println(user.getName());

    }
}
