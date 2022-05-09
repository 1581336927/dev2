package com.hcy.test;

import com.hcy.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@DisplayName("断言测试类")
@SpringBootTest
public class AssertTest {

    @Autowired
    private Student student1;
    @Autowired
    private Student student2;


    @Test
    void test(){
        System.out.println("你好");
    }

    public  int add(int num1,int num2){
        return num1+num2;
    }

    @Test
    @DisplayName("简单断言是否是相同的")
    void testAssertEquals(){

        Assertions.assertEquals(3,add(1,2));
    }

    @Test
    @DisplayName("简单断言是否为同一个对象v")
    void testAssertEqualsObj(){
        Assertions.assertSame(student1,student2,"你们的学生是同一个人");
    }


    @Test
    @DisplayName("断言是true还是false")
    void testAssertEqualsTrue(){
        Assertions.assertTrue(student1==student2&&1<0,"你们的学生是同一个人");
    }


    @Test
    @DisplayName("数组")
    void testAssertEqualsArrays(){
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{2,3},"不是同一个数组");

    }

    @Test
    @DisplayName("组合断言")
    void testAssertAll(){
        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(new int[]{1, 2}, new int[]{2, 3}, "不是同一个数组"),
                () -> Assertions.assertTrue(student1==student2&&1<0,"你们的学生是同一个人"));

    }

    @Test
    @DisplayName("测试异常断言")
    void testException(){
        Assertions.assertThrows(ArithmeticException.class,()->{
            int num=1/0;
        },"代码竟然没问题");
    }

    @Test
    @DisplayName("超时断言")
        void testAssertTimeout(){
        Assertions.assertTimeout(Duration.ofSeconds(3L), new Executable() {
            @Override
            public void execute() throws Throwable {
                Thread.sleep(4000);
            }
        },"太快了，还没跟上");
    }

    @Test
    @DisplayName("测试快速失败")
    void  testFail(){
        Assertions.fail("失败了");
    }
}
