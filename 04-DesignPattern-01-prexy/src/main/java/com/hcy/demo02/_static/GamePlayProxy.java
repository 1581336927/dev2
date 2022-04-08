package com.hcy.demo02._static;


//代理对象
public class GamePlayProxy implements GamePlay {

    private  GamePlay gamePlayer;




    @Override
    public void login() {
        gamePlayer.login();
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
    }

    @Override
    public void upGrade() {
        this.luckDraw();
        gamePlayer.upGrade();
    }

    private void luckDraw() {
        System.out.println("抽到了屠龙刀");
    }

    public GamePlayProxy(GamePlay gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

}
