package com.hcy.config;

import com.hcy.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//说明这个类是配置类
@Configuration
@ComponentScan("com.hcy")
public class MyConfig {

    @Bean
    public User getUser(){
        return new User();
    }

}
