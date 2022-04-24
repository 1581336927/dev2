package com.hcy.dao;
import com.hcy.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Mapper
@Repository
public interface StudentDao {
    List<Student> findAll();

}
