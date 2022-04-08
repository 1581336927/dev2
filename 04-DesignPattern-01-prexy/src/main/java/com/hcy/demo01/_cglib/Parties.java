package com.hcy.demo01._cglib;

//被代理的对象
public class Parties implements Lawsuit{


    @Override
    public void submit() {
        System.out.println("欠钱跑路了");
    }

    @Override
    public void defend() {

        System.out.println("还我血汗钱");
    }
}
