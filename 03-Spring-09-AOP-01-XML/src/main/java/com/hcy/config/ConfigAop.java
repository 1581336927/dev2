package com.hcy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//扫描指定包下的注解
@ComponentScan(basePackages = "com.hcy")
//声明这是一个配置类
@Configuration
//生成代理对象
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {


}
