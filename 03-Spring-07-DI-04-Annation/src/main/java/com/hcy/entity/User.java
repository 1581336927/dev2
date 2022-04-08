package com.hcy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@AllArgsConstructor

//把当前类的对象放在容器中
@Component

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class User {
    @Value("102")
    private Integer id;
    @Value("易烊千玺")
    private String name;
    @Value("415456456")
    private String password;
    //和init方法伊扬类加载时就加载
    @PostConstruct
    public void  eat(){
        System.out.println("今天吃大米饭");
    }
    //和销毁方法一样
    @PreDestroy
    public void  sleep(){
        System.out.println("吃完就睡觉");
    }

    public User() {
        System.out.println("构造方法");
    }
}
