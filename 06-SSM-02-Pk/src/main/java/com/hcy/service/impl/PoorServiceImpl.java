package com.hcy.service.impl;

import com.hcy.dao.PoorMapper;
import com.hcy.entity.Poor;
import com.hcy.service.PoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PoorServiceImpl implements PoorService {

    @Autowired
    private PoorMapper poorMapper;



}
