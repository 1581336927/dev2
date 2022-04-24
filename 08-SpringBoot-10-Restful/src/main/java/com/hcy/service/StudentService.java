package com.hcy.service;



import com.hcy.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    int insert(Student student);

    int update(Integer id,String info);

    int delete(Integer id);
}
