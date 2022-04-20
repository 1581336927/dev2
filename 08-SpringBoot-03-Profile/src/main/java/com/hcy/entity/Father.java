package com.hcy.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@Component
@Data
@ConfigurationProperties(prefix = "student")
public class Father implements Student{
    private String name;
    private Integer age;
}
