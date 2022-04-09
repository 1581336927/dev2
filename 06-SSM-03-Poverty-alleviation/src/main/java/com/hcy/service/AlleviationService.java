package com.hcy.service;

import com.hcy.controller.AlleviationController;
import com.hcy.entity.Alleviation;
import com.hcy.vo.ResultVo;

import java.util.Date;

public interface AlleviationService {
    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(Alleviation alleviation);

    ResultVo update(Alleviation alleviation);

    ResultVo delete(Long id);

    ResultVo click(Long id, Date lastClickTime);
}
