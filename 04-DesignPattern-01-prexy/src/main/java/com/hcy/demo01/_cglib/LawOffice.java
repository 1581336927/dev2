package com.hcy.demo01._cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LawOffice implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName().equals("submit")){
            System.out.println("美的呀刺啦着笑");
        }

        //让代理对象执行真实对象中的方法

        Object o = proxy.invokeSuper(obj, args);

        if (method.getName().equals("defend")){
            System.out.println("哈哈哈哈哈");
        }

        return o;
    }
}
