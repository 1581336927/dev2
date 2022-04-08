package com.hcy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataVo<T> {
    private Long total;
    private List<T> list;
    private Integer pageNum;
    private Integer pageSize;
}
