package com.hcy.demo01._jdk;

//当事人，被代理对象

public class Parties implements Lawsuit{
    @Override
    public void submit() {
        System.out.println("老板欠薪带着小姨子跑路");
    }

    @Override
    public void defend() {
        System.out.println("还我血汗钱");
    }
}
