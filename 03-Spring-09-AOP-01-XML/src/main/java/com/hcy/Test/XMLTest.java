package com.hcy.Test;

import com.hcy.entiyi.Book;
import com.hcy.entiyi.User;
import com.hcy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = applicationContext.getBean(UserService.class);

        userService.add();

        System.out.println("------------华丽-----------");

        userService.update();
    }

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        User bean = applicationContext.getBean(User.class);

        bean.add();
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Book bean = applicationContext.getBean(Book.class);

        bean.buy();
    }
}
