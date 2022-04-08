package com.hcy.entiyi;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserProxy {
    @Pointcut(value = "execution(* com.hcy.entiyi.User.add(..))")
    public static void test(){

    }


    @Before(value = "test()")
    public void before(){
        System.out.println("before...");
    }
    @After(value = "test()")
    public void  after(){
        System.out.println("after.....");
    }

    @Around(value = "execution(* com.hcy.entiyi.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }


}
