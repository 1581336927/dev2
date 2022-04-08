package com.hcy.Ditest;

import com.hcy.entity.Car;
import com.hcy.entity.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testCar {

    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = classPathXmlApplicationContext.getBean("car", Car.class);
        System.out.println(car);
        Person person = classPathXmlApplicationContext.getBean(Person.class);
        System.out.println(person);
    }
}
