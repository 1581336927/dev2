package com.hcy.service;

import com.hcy.entity.VolunteerRecruitment;

import java.util.Map;

public interface VolunteerService {
    Map<String, Object> addVolunteer(VolunteerRecruitment volunteerRecruitment);
}
