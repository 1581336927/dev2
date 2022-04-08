package com.hcy.controller;

import com.hcy.entity.Carousel;
import com.hcy.service.CarouselService;
import com.hcy.service.impl.CarouselImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    //轮播图插入数据
    @RequestMapping("add")
    public Map<String,Object> insertCarousel(Carousel carousel){
        return carouselService.insertCarousel(carousel);

    }

    //根据Id删除轮播图
    @RequestMapping("del")
    public Map<String ,Object> deleteCarousel(Integer id){
        return carouselService.deleteCarousel(id);
    }
    //轮播图修改
    @RequestMapping("update")
    public Map<String ,Object> updateCarousel(Carousel carousel){
        return carouselService.updateCarousel(carousel);
    }
    //boolean类型获取表
    @RequestMapping("list")
    public Map<String, Object> ListCarousel( ){
        return carouselService.selectCarousel();
    }
}
