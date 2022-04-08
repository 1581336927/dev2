package com.hcy.controller;

import com.hcy.entity.TbMusic;
import com.hcy.entity.TbSheet;
import com.hcy.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sheet")
public class TbSheetController {
    @Autowired
    private TbSheetService sheetService;

    @RequestMapping("findAll")
    public List<TbSheet> findAll(){

        return sheetService.findAll();

    }

    @RequestMapping("findSongsBySheet")
    public List<TbMusic> findSongsBySheet(String sheetName) {
        return sheetService.findSongsBySheet(sheetName);
    }

    @RequestMapping("insertSheet")
    public Map<String, Object> insertSheet(TbSheet sheetName){

       return sheetService.insertSheet(sheetName);
    }
}
