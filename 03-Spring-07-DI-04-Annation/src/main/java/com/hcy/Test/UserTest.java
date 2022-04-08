package com.hcy.Test;

import com.hcy.controller.UserController;
import com.hcy.entity.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.hcy");

        User user = context.getBean(User.class);

        System.out.println(user);
        context.close();
    }

@Test
    public void test1(){
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserController user = context.getBean(UserController.class);

    List<User> list = user.findAll();

    System.out.println(list);
}


}
