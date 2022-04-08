package com.hcy.Test;

import com.hcy.entity.ComplexType;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComplexTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ComplexType type = context.getBean(ComplexType.class);

        System.out.println(type);
    }
}
