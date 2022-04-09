package com.hcy.service;


import com.hcy.entity.User;
import com.hcy.entity.VolunteerRecruitment;
import com.hcy.vo.ResultVo;

import java.util.Date;

public interface VolunteerService {
    ResultVo getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(VolunteerRecruitment volunteerRecruitment);

    ResultVo update(VolunteerRecruitment volunteerRecruitment);

    ResultVo delete(Long id);

    ResultVo click(Long id, Date lastClickTime);

}
