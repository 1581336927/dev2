package com.hcy.config;


import com.hcy.entity.Cat;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//此注解相当于交给容器创建对象
@Import(Cat.class)
public class CatConfig {


}
