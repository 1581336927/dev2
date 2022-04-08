package com.hcy.entity;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer id;
    private String name;
    List<Employee> employees;
}
