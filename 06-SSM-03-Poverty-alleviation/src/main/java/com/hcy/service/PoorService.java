package com.hcy.service;

import com.hcy.entity.Poor;
import com.hcy.entity.PoorWithBLOBs;
import com.hcy.vo.ResultVo;

import java.util.Date;

public interface PoorService {
    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo insert(PoorWithBLOBs poor);


    ResultVo click(Long id, Date lastClickTime);

    ResultVo delete(Long id);

    ResultVo update(PoorWithBLOBs poor);
}
