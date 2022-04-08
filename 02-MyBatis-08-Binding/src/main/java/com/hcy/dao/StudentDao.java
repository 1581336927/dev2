package com.hcy.dao;


import com.hcy.entity.Student;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student findByIdAndName(Integer id,String name);

    Student findByAgeAndName(Integer age,String name);


    Student findByGenderAndName(@Param("gender") String gender, @Param("name") String name);

    Integer insert(Map<String, Object> map);

    Integer insertStudent(Student student);

}
