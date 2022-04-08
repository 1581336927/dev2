package com.hcy.controller;

import com.hcy.entity.VolunteerRecruitment;
import com.hcy.service.VolunteerService;
import com.hcy.service.impl.VolunteerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("recruitment")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;
    //添加数据
    @RequestMapping("add")
    public Map<String, Object> addVolunteer(VolunteerRecruitment volunteerRecruitment){
        return volunteerService.addVolunteer(volunteerRecruitment);
    }
}
