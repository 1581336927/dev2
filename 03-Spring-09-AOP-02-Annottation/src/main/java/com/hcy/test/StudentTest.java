package com.hcy.test;

import com.hcy.service.impl.StudentServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentServiceImpl service = context.getBean(StudentServiceImpl.class);

        service.add();
    }
}
