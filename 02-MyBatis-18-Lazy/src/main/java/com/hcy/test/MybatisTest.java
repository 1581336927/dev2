package com.hcy.test;


import com.hcy.dao.EmployeeDao;
import com.hcy.entity.Employee;
import com.hcy.util.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

@Test
    public void test(){
    EmployeeDao dao = MyBatisUtils.getMapper(EmployeeDao.class);
    List<Employee> all = dao.findAll(1);

    MyBatisUtils.commit();
}
}
