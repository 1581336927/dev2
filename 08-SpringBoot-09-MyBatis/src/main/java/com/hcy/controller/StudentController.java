package com.hcy.controller;

import com.github.pagehelper.PageInfo;
import com.hcy.entity.Student;
import com.hcy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("findAll")
    public List<Student> findAll(){


        return studentService.findAll();
    }


    @RequestMapping("findByPage")
    public PageInfo<Student> findByPage(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize){

        return studentService.findByPage(pageNum,pageSize);
    }
}
