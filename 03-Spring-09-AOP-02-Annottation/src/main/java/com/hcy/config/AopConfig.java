package com.hcy.config;


import com.hcy.advice.AnnotationAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.hcy")
@Configuration
public class AopConfig {

    @Bean
    public AnnotationAdvice annotationAdvice() {
        return new AnnotationAdvice();
    }
}
