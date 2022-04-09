package com.hcy.controller;

import com.hcy.entity.User;
import com.hcy.entity.VolunteerRecruitment;
import com.hcy.service.VolunteerService;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("volunteer")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;


    @GetMapping("getlist")
    public ResultVo getlist(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Long id){

        return volunteerService.getlist(pageNum,pageSize,id);
    }
    @PostMapping("click")
    public ResultVo chick(VolunteerRecruitment volunteerRecruitment){
        return volunteerService.click(volunteerRecruitment.getId(),volunteerRecruitment.getLastClickTime());
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody VolunteerRecruitment volunteerRecruitment){

        return volunteerService.add(volunteerRecruitment);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerService.update(volunteerRecruitment);
    }
    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return volunteerService.delete(id);
    }
}
