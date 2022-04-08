package com.hcy.entity;

public class UserT {

    private String name;

    public UserT() {
        System.out.println("UserT的无参构造");
    }
    public void show(){
        System.out.println("name="+name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
