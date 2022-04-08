package com.hcy.test;

import com.hcy.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lifecycle {
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = classPathXmlApplicationContext.getBean("student", Student.class);
        System.out.println(student);

        classPathXmlApplicationContext.close();
    }
}
