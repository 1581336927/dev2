package com.hcy.dao;


import com.hcy.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> findAll();

    List<Student> keyWord(@Param("name") String name,@Param("age") Integer age);

    List<Student> findByStudent(Student student);

    Integer updateStudent(Student student);

    int deleteMore(Integer... ids);
}
