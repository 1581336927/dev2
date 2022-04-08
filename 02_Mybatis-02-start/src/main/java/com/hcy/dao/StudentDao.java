package com.hcy.dao;

import com.hcy.entity.Student;

public interface StudentDao {

    Student selectId(Integer id);

    int InsertStu();

    Student SelectId(int i);
}
