package com.hcy.controller;

import com.hcy.entity.Collection;
import com.hcy.service.CollectionService;
import com.hcy.service.impl.CollectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("collect")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;


    //分压查询
    @RequestMapping("list")
    public Map<Object, Object> selectLimit(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue= "5") Integer pageSize){
        return collectionService.selectLimit(pageNum,pageSize);
    }
     //添加收藏
    @RequestMapping("add")
    public Map<String, Object> insertCollection(Collection collection){
        return collectionService.insertCollection(collection);
    }
    //收藏根据Id进行删除
    @RequestMapping("del")
    public Map<String, Object> deleteCollection(Integer id){
        return collectionService.deleteCollection(id);
    }

}
