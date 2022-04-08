package com.hcy.dao;


import com.hcy.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    List<Student> findByKeyword(@Param("keyword") String keyword);

    int getAutoIncrement(Student student);
}
