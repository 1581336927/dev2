package com.hcy.controller;

import com.hcy.entity.Carousel;
import com.hcy.entity.User;
import com.hcy.service.CarouselService;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;


    @GetMapping("getlist")
    public ResultVo getlist(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Integer id){

        return carouselService.getlist(pageNum,pageSize,id);
    }


    @PostMapping("add")
    public ResultVo add(@RequestBody Carousel carousel){

        return carouselService.add(carousel);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }
    @GetMapping("delete")
    public ResultVo delete(@RequestParam Integer id){
        return carouselService.delete(id);
    }
}
