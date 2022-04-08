package com.hcy.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}
