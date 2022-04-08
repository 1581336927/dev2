package com.hcy.dao;


import com.hcy.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> selectAge(Integer integer);

    Student selectStuOne(Integer integer);

    Integer deleteStu(Integer integer);

    Integer InsertStu();

    Integer updateStu(Student student);

    Integer insertStu2(Map<String,Object> map);
    List<Student> getId(String name);

    Student selectS(Integer integer);
}
