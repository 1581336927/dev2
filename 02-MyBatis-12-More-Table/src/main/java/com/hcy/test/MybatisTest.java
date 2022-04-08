package com.hcy.test;


import com.hcy.dao.DepartmentDao;
import com.hcy.dao.EmployeeDao;
import com.hcy.dao.StudentDao;
import com.hcy.dao.SubjectDao;
import com.hcy.entity.Department;
import com.hcy.entity.Employee;
import com.hcy.entity.Student;
import com.hcy.entity.Subject;
import com.hcy.util.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

    @Test
    public void test() {
        EmployeeDao employeeDao = MyBatisUtils.getMapper(EmployeeDao.class);

        List<Employee> list = employeeDao.findAll();

        for (Employee employee : list) {
            System.out.println(employee);
        }
        MyBatisUtils.commit();
    }

    @Test
    public void test1() {
        DepartmentDao departmentDao = MyBatisUtils.getMapper(DepartmentDao.class);

        List<Department> allDt = departmentDao.findAllDt();

        for (Department department : allDt) {
            System.out.println(department);

        }
        MyBatisUtils.commit();
    }

    @Test
    public void test2(){
        StudentDao studentDao = MyBatisUtils.getMapper(StudentDao.class);

        List<Student> list = studentDao.findAll();

        for (Student student : list) {
            System.out.println(student);
        }
        MyBatisUtils.commit();
    }

    @Test
    public void test3(){
        SubjectDao subjectDao = MyBatisUtils.getMapper(SubjectDao.class);

        List<Subject> subjectList = subjectDao.findAll();

        for (Subject subject : subjectList) {
            System.out.println(subject);
        }
        MyBatisUtils.commit();
    }

}
