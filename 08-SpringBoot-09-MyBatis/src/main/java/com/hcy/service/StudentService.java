package com.hcy.service;


import com.github.pagehelper.PageInfo;
import com.hcy.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> findAll();


    PageInfo<Student> findByPage(Integer pageNum, Integer pageSize);
}
