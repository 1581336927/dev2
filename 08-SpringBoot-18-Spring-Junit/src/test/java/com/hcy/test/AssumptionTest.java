package com.hcy.test;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("假设")
@Nested
public class AssumptionTest {


    class  A{

    }

    //环境
    public String environment="test";
    @DisplayName("测试简单的假设")
    @Test
    void  testSimpleAssume(){
        Assumptions.assumeFalse(environment.equals("dev"));
    }

    @Test
    @DisplayName("测试假设之后")
    void testAssumeThen(){
        Assumptions.assumingThat(environment.equals("test"),()->{
            System.out.println("当前环境并不是test");
        });
    }
}
