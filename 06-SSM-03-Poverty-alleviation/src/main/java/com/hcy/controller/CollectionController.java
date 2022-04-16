package com.hcy.controller;

import com.hcy.entity.Collection;
import com.hcy.service.CollectionService;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;
    @GetMapping("getlist")
    private ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                             Long id){
        return collectionService.getList(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo insert(@RequestBody Collection collection){
        return collectionService.insert(collection);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody Collection collection){
        return  collectionService.update(collection);
    }

    @GetMapping("delete")
    public  ResultVo delete(@RequestParam("id") Long id){
        return  collectionService.delete(id);
    }
}
