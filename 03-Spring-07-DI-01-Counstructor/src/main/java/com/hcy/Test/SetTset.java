package com.hcy.Test;

import com.hcy.entity.Student;
import com.hcy.entity.Teacher;
import com.hcy.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTset {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student bean = context.getBean(Student.class);

        System.out.println(bean);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);
    }

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = context.getBean(User.class);

        user.show();
    }
}
