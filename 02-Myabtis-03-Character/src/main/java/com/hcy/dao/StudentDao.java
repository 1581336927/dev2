package com.hcy.dao;

import com.hcy.entity.Student;

public interface StudentDao {

    Integer InsertStu();

    Student SelectId(Integer i);
}
