package com.hcy.service.impl;

import com.hcy.dao.TbNoteTypeMapper;
import com.hcy.entity.TbNoteType;
import com.hcy.entity.TbUser;
import com.hcy.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class NoteTypeServiceImpl implements NoteTypeService {

    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;

    @Override
    public ModelAndView findByNoteType(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        TbUser user = (TbUser) session.getAttribute("user");

        List<TbNoteType> list = tbNoteTypeMapper.selectType(user.getId());

        request.setAttribute("list",list);

        request.setAttribute("menu_page","/type");

        request.setAttribute("changePage","/type/list.jsp");

        ModelAndView view = new ModelAndView();

        view.setViewName("forward:/index.jsp");
        return view;
    }

    @Override
    public ModelAndView addOrUpdate(Integer typeId, String typeName,HttpServletRequest request) {

        ModelAndView view = new ModelAndView();

        HttpSession session = request.getSession(false);

        TbUser user = (TbUser) session.getAttribute("user");


        if (typeId==null){
            Integer integer = tbNoteTypeMapper.insertType(typeName,user.getId());

            if (integer>0){
                view.addObject("code",1);
                view.addObject("message","插入成功");
            }else {
                view.addObject("code",0);
                view.addObject("message","插入失败");
            }


        }else{
            Integer updateType = tbNoteTypeMapper.updateType(typeName, user.getId(),typeId);
//            Integer updateType = tbNoteTypeMapper.updateType(typeName,typeId,user.getId());
            System.out.println(user.getId());
            if (updateType>0){
                view.addObject("code",1);
                view.addObject("message","修改成功");
            }else {
                view.addObject("code",0);
                view.addObject("message","修改失败");
            }
        }
        view.setViewName("/index.jsp");

        return view;
    }
}
