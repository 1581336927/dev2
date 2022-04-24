package com.hcy.exeception;


//自定义异常
public class SingletonException extends Exception {
    public SingletonException() {
        super();
    }

    public SingletonException(String message) {
        super(message);
    }
}
