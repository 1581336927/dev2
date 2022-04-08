package com.hcy.entity;

public class Student {

    private Integer id;
    private String name;
    private Byte age;

    public Student() {
        System.out.println("无参构造被执行");
    }

    public Student(Integer id, String name, Byte age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public void init(){
        System.out.println("初始化");
    }
    public void destroy(){
        System.out.println("销毁");
    }
}
