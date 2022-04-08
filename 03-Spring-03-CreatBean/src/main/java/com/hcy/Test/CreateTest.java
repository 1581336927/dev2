package com.hcy.Test;

import com.hcy.Factory.StudentFactory;
import com.hcy.Factory.StudentStaticFactory;
import com.hcy.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTest {
    @Test
    public void test(){
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = context.getBean("student", Student.class);

        System.out.println(student);
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student2 = context.getBean("student2", Student.class);

        System.out.println(student2);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student3 = context.getBean("student3", Student.class);

        System.out.println(student3);
    }
}
