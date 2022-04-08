package com.hcy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private int id;
    private String name;
    // 一个部门中有多个员工
    private List<Employee> employeeList;
    
    // Constructor、Setter、Getter
}