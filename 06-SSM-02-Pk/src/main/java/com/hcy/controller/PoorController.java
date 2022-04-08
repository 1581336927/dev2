package com.hcy.controller;

import com.hcy.entity.Poor;
import com.hcy.service.PoorService;
import com.hcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

}
