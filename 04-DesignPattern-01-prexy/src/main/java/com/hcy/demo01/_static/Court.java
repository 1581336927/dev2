package com.hcy.demo01._static;

import org.junit.Test;

public class Court {
    @Test
    public void test(){

        //接口的实现类对应接口
        //原告击鼓鸣冤
        Lawsuit parties = new Parties();

        //代理对象增强证据
        Lawyer lawyer = new Lawyer(parties);

        lawyer.defend();
        lawyer.submit();
    }
}
