package com.hcy.service;

import com.hcy.controller.TbNoteTypeController;
import com.hcy.entity.TbNoteType;
import com.hcy.vo.ResultVO;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TbNoteTypeService {


    ResultVO delete(TbNoteType tbNoteType, HttpServletRequest request);

    List<TbNoteType> getTypes(Integer id);

    ResultVO add(TbNoteType type);

    ResultVO update(TbNoteType type);
}
