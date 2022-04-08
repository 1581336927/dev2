package com.hcy.test;


import com.github.pagehelper.PageHelper;
import com.hcy.dao.StudentDao;
import com.hcy.entity.Student;
import com.hcy.util.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void testPage() {
        // 通过工具类获取接口的实现类
        StudentDao mapper = MyBatisUtils.getMapper(StudentDao.class);


        // 执行sql语句
        List<Student> list = mapper.findAll();

        // 遍历结果
        for (Student student : list) {
            System.out.println(student);
        }

        // 提交事务
        MyBatisUtils.commit();
    }
}
