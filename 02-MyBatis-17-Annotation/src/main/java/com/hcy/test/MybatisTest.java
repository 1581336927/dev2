package com.hcy.test;


import com.hcy.dao.StudentDao;
import com.hcy.entity.Student;
import com.hcy.util.MyBatisUtils;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

    @Test
    public void test(){
        StudentDao dao = MyBatisUtils.getMapper(StudentDao.class);
        List<Student> all = dao.findAll();
        for (Student student : all) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
}
