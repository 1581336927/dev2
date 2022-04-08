package com.hcy.Factory;

import com.hcy.entity.Student;

public class StudentStaticFactory {
    public static Student getStudent(){
        return new Student();
    }
}
