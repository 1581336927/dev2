package com.hcy.demo02._static;

//被代理对象
public class GamePlayer implements GamePlay {
    @Override
    public void login() {
        System.out.println("爷傲奈我何");
    }

    @Override
    public void killBoss() {

        System.out.println("带怪兽");
    }

    @Override
    public void upGrade() {

        System.out.println("升级");
    }
}
