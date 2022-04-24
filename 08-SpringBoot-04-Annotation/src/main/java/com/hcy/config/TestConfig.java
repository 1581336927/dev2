package com.hcy.config;


import com.hcy.entity.Car;
import com.hcy.entity.Person;
import com.hcy.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


//此注解表示当前类是一个配置类，是否开启代理对象
@Configuration(proxyBeanMethods = false)
public class TestConfig {
    //此注解把返回值装配到容器中

    @Bean({"car1","car2","car3"})
    public Car getCar(){
        return new Car("保时捷","粉色");
    }

    @Bean
    //参数会自动从容器中获取
    public Person getPerson(Car car){
        return  new Person("韩晨宇",getCar());
    }

    //将User实体类的对象注入到容器中
    @Bean
//    @Scope("prototype")
    public User getUser(){
        return new User();
    }

    public TestConfig(){
        System.out.println("构造方法执行");
    }

    public String test(){
        System.out.println("李豪爱蜥蜴");
        return "一次三秒";
    }
    //构造方法执行后此方法执行
    //只要是javaweb都能使用此注解
    @PostConstruct
    public  void  init(){

        System.out.println("初始化方法执行");
    }
}
