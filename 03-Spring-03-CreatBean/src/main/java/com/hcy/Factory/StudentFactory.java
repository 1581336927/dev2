package com.hcy.Factory;

import com.hcy.entity.Student;

public class StudentFactory {
    public Student getStudent(){
        return new Student();
    }
}
