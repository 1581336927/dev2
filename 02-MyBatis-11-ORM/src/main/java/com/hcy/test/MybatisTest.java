package com.hcy.test;


import com.hcy.dao.ManagerDao;
import com.hcy.dao.StudentDao;
import com.hcy.entity.Manager;
import com.hcy.entity.Student;
import com.hcy.util.MyBatisUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MybatisTest {

    //给数据库字段起别名
    @Test
    public void findAll(){
        ManagerDao managerDao = MyBatisUtils.getMapper(ManagerDao.class);

        List<Manager> managerList = managerDao.findAll();

        for (Manager manager : managerList) {
            System.out.println(manager);
        }
        MyBatisUtils.commit();
    }

    //ResultMap结果集映射
    @Test
    public void findId(){
        ManagerDao managerDao = MyBatisUtils.getMapper(ManagerDao.class);

        Manager manager = managerDao.findId(2);

        System.out.println(manager);

        MyBatisUtils.commit();
    }
}
