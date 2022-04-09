package com.hcy.service;

import com.hcy.entity.Collection;
import com.hcy.vo.ResultVo;

public interface CollectionService {
    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo insert(Collection collection);

    ResultVo update(Collection collection);

    ResultVo delete(Long id);

}
