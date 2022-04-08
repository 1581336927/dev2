package com.hcy.entity;



import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Byte age;
    private String gender;
    private Date birthday;
    private  String info;
}
