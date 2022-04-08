package com.hcy.dao;


import com.hcy.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    Student findById(@Param("id") Integer id);

    Integer updateStu(Student student);


}
