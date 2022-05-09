package com.hcy.controller;


import com.hcy.entity.TbNoteType;
import com.hcy.entity.TbUser;
import com.hcy.service.TbNoteTypeService;
import com.hcy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("type")
public class TbNoteTypeController {

    @Autowired
    private TbNoteTypeService tbNoteTypeService;


    @GetMapping("list")
    public ModelAndView list(ModelAndView mv, HttpSession session) {
        // 根据用户的id获取该用户的所有日记类别
        TbUser user = (TbUser) session.getAttribute("user");

        List<TbNoteType> types = tbNoteTypeService.getTypes(user.getId());

        mv.addObject("list", types);
        mv.addObject("menu_page", "type");
        mv.addObject("changePage", "/type/list.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }

    @GetMapping("delete")
    @ResponseBody
    public ResultVO delete(TbNoteType tbNoteType, HttpServletRequest request){

        return tbNoteTypeService.delete(tbNoteType,request);
    }

    @PostMapping("addOrUpdate")
    @ResponseBody
    public ResultVO addOrUpdate(TbNoteType type, HttpSession session) {
        TbUser user = (TbUser) session.getAttribute("user");

        type.setUserId(user.getId());

        ResultVO vo;

        System.out.println(type.getId());
        // 如果没有传递类型的id那么执行的是添加
        if (type.getId() == null) {
            vo = tbNoteTypeService.add(type);
        } else {
            vo = tbNoteTypeService.update(type);
        }

        return vo;
    }
}
