package com.hcy.service;

import com.hcy.entity.Carousel;
import com.hcy.vo.ResultVo;

public interface CarouselService {
    ResultVo getlist(Integer pageNum, Integer pageSize, Integer id);

    ResultVo add(Carousel carousel);

    ResultVo update(Carousel carousel);

    ResultVo delete(Integer id);
}
