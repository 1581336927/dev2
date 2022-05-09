package com.hcy.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface NoteTypeService {
    ModelAndView findByNoteType(HttpServletRequest request);

    ModelAndView addOrUpdate(Integer typeId, String typeName, HttpServletRequest request);
}
