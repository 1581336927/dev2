package com.hcy.test;

import com.hcy.config.AopConfig;
import com.hcy.service.UserService;
import com.hcy.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    @Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);

        userService.add();
        userService.update();
    }

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService service = context.getBean(UserService.class);

        service.add();

        System.out.println("------------------");

        service.update();
    }
}
