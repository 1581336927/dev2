package com.hcy.dao;


import com.hcy.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {
    // 查询所有学生
    @Select("select * from student")
    List<Student> findAll();
}
