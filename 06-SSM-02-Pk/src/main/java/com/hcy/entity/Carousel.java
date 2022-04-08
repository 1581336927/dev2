package com.hcy.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Carousel implements Serializable {
    private Integer id;
    private String name;
    private String picture;
    private Integer available;

}
