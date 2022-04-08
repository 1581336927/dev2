package com.hcy.dao;

import com.hcy.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    //根据部门id查询指定部门下的所有员工
    List<Employee> findAll(@Param("id") Integer id);
}
