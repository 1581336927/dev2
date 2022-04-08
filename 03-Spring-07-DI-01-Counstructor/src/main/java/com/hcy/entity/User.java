package com.hcy.entity;

public class User {
    private String name;

    public User() {
        System.out.println("User的无参构造");
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

    public User(String name) {
        this.name = name;
    }
}
