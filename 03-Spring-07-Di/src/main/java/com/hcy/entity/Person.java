package com.hcy.entity;

public class Person {
    String name;
    Byte age;
    Car car;

    public Person(String name, Byte age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
