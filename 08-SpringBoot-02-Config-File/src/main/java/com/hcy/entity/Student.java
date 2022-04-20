package com.hcy.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Component
@Data
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer age;
    private String gender;
    private Boolean married;
    private String info;
    private String[] hobby;
    private Date birthday;
    private List<String> food;
    private Map<String, Object> score;
    private Car car;
}
