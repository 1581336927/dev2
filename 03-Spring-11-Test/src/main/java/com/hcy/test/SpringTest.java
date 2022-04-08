package com.hcy.test;

import com.hcy.entity.Car;
import com.hcy.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 用于指定junit的运行环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private Person person;
    @Autowired
    private Car car;

    @Test
    public void testPerson() {
        System.out.println(person);
    }

    @Test
    public void testCar() {
        System.out.println(car);
    }
}