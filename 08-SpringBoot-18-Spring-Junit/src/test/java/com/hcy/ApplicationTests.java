package com.hcy;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

//加载Spring容器环境
@SpringBootTest
@DisplayName("Junit5测试注解类")
class ApplicationTests {

    @Test
    @DisplayName("Junit5测试注解方法")
    void test(){
        System.out.println("测试");
    }

    @Test
    @DisplayName("测试add方法")
    void testAdd(){
        System.out.println("测试");
    }

    @Test
    @Disabled
    @DisplayName("测试Disabled方法")
    void testDisabled(){
        System.out.println("测试Disabled");
    }

    @Test
    @DisplayName("测试超时注解")
     @Timeout(value = 3)
    void testTimeOut(){

        try {
            Thread.sleep(3000);
            System.out.println("测试超市注解");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }


    @RepeatedTest(3)
    void testRepeatedTest(){
        System.out.println("今天想吃猪蹄");
    }

    @Tag("蜥蜴")
    @Test
    @DisplayName("测试tag注解")
    void testTag(){
        System.out.println("李豪爱蜥蜴");
    }
    @Tag("蜥蜴")
    @Test
    @DisplayName("测试tag注解")
    void testTag1(){
        System.out.println("李豪爱蚂蝗");
    }
    @Tag("蜥蜴")
    @Test
    @DisplayName("测试tag注解")
    void testTag2(){
        System.out.println("李豪爱野猪");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试方法执行之前执行");
    }


    //常用于释放资源
    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试方法执行之后执行，只执行一次");
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("开始测试");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("结束测试");
    }
}
