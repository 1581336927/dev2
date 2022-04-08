package com.hcy.demo02._static;

import org.junit.Test;

public class Client {
    @Test
    public void test(){
        GamePlay gamePlayer = new GamePlayer();

        GamePlayProxy proxy = new GamePlayProxy(gamePlayer);

        proxy.killBoss();
        proxy.upGrade();
        proxy.login();
    }

}
