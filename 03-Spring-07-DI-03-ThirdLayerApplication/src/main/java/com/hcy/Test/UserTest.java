package com.hcy.Test;

import com.hcy.service.UserService;
import com.hcy.service.impl.UserServiceImpl;
import com.hcy.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void test(){
        UserService service = new UserServiceImpl();
        System.out.println(service.findAll());
    }

    @Test
     public void Test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        UserController user3 = context.getBean(UserController.class);

        System.out.println(user3.findAll());

    }


}
