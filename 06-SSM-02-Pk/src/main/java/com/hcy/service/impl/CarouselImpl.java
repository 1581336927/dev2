package com.hcy.service.impl;

import com.hcy.dao.CarouselMapper;
import com.hcy.entity.Carousel;
import com.hcy.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarouselImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public Map<String, Object> insertCarousel(Carousel carousel) {

        int i = carouselMapper.insertCarousel(carousel);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("errMsg","错误描述");
        if (i > 0) {
            map.put("message", "添加成功");
            map.put("code", 200);
            map.put("success",true);
            map.put("data",null);
        }else {
            map.put("message","添加失败！");
            map.put("code",500);
            map.put("success",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteCarousel(Integer id) {

        int i = carouselMapper.deleteCarousel(id);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("errMsg","错误描述");
        if (i > 0) {
            map.put("message", "删除成功");
            map.put("code", 200);
            map.put("success",true);
            map.put("data",null);
        }else {
            map.put("message","删除失败！");
            map.put("code",500);
            map.put("success",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateCarousel(Carousel carousel) {
        Integer i = carouselMapper.updateCarousel(carousel);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("errMsg","错误描述");
        if (i > 0) {
            map.put("message", "删除成功");
            map.put("code", 200);
            map.put("success",true);
            map.put("data",null);
        }else {
            map.put("message","删除失败！");
            map.put("code",500);
            map.put("success",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> selectCarousel() {
        Map<String, Object> map=new HashMap<>();
        List<Carousel> list= carouselMapper.selectCarousel();
        if (list==null){
            map.put("message","获取失败！");
            map.put("code",500);
            map.put("success",false);
        }else {
            map.put("message", "获取成功");
            map.put("code", 200);
            map.put("success",true);
            map.put("data",list);
            map.put("carouselNum",list.size());
        }

        return map;
    }
}
