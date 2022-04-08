package com.hcy.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationStudent {

    @Pointcut("execution(* com.hcy.service.impl.*ServiceImpl.*(..))")
    public static void test(){

    }

    @Before(value = "test()")
    public void before(){
        System.out.println("删了一个学生");
    }
}
