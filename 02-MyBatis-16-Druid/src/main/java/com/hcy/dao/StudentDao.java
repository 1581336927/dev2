package com.hcy.dao;


import com.hcy.entity.Student;

import java.util.List;

public interface StudentDao {
    // 查询所有学生
    List<Student> findAll();
}
