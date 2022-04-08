package com.hcy.dao;


import com.hcy.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();
}
