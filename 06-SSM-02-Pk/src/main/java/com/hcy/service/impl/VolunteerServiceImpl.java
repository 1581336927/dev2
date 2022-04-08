package com.hcy.service.impl;

import com.hcy.dao.VolunteerRecruitmentMapper;
import com.hcy.entity.VolunteerRecruitment;
import com.hcy.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;


    @Override
    public Map<String, Object> addVolunteer(VolunteerRecruitment volunteerRecruitment) {
        Map<String, Object> map = new HashMap<>();
        map.put("message","失败");
        map.put("code",-1);
        map.put("success",false);
        map.put("data","{}");
        int i = volunteerRecruitmentMapper.insert(volunteerRecruitment);
        if (i>0){
            map.put("message","成功");
            map.put("code",200);
            map.put("success",true);
            map.put("data","{}");
        }

        return map;
    }
}
