package com.hcy.dao;

import com.hcy.entity.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerDao {

    List<Manager> findAll();

    Manager findId(@Param("id") Integer id);
}
