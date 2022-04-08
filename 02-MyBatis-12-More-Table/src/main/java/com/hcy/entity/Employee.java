package com.hcy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    // 一个员工对应一个部门
    private Department department;
    
    // Constructor、Setter、Getter
}