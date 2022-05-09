package com.hcy.controller;

import com.hcy.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("type")
public class NoteTypeController {

    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("list")
    public ModelAndView getList(HttpServletRequest request){

        return noteTypeService.findByNoteType(request);
    }

    @PostMapping("addOrUpdate")
    public ModelAndView addOrUpdate(@RequestParam("id") Integer typeId,@RequestParam("typeName") String typeName,@RequestParam(value = "userID",required = false) Integer userID,HttpServletRequest request){

        return noteTypeService.addOrUpdate(typeId,typeName,request);
    }
}
