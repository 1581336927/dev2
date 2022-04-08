package com.test;

import com.fc.config.TxtConfig;
import com.hcy.service.AccountService;
import com.hcy.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    @Test
    public void test(){

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

            AccountService accountService = applicationContext.getBean("annotationService", AccountService.class);

            accountService.transfer(1, 2, 500L);
        }
}
