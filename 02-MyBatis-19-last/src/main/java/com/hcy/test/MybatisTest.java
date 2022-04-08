package com.hcy.test;

import com.hcy.dao.StudentMapper;
import com.hcy.entity.Student;
import com.hcy.util.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

    @Test
    public void select(){
        StudentMapper mapper = MyBatisUtils.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectByExample(null);
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }
}
