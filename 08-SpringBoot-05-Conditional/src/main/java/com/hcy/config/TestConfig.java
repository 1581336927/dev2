package com.hcy.config;

import com.hcy.entity.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {


    @Bean
    @ConditionalOnMissingBean({Bike.class,Person.class})
    @ConditionalOnBean(Person.class)
    public Car getCar(){
        Car car = new Car();
        car.setBrand("凤凰牌");
        return car;
    }

    @Bean("car2")
    public Car getCar2(){
        Car car = new Car();
        car.setBrand("自行车");
        return car;
    }

    @Bean("car3")
    public Car getCar3(){
        Car car = new Car();
        car.setBrand("业主拍");
        return car;
    }

//    @Bean("wife")
    public Wife getWife() {
        return new Wife();
    }

    @Bean("son")
    // 如果容器中有Wife类的对象就注入Son
    @ConditionalOnBean(Wife.class)
    public Son getSon() {
        return new Son();
    }

    @Bean("girlFriend")
    // 如果没有老婆就可有女朋友
    @ConditionalOnMissingBean(Wife.class)
    public GirlFriend getGirlFriend() {
        return new GirlFriend();
    }
}
