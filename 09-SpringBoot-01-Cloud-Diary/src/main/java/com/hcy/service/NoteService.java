package com.hcy.service;

import com.hcy.entity.TbNote;
import com.hcy.vo.NoteVO;
import com.hcy.vo.ResultVO;

public interface NoteService {
    NoteVO findById(Integer id);

    ResultVO update(TbNote note);

    ResultVO add(TbNote note);

    ResultVO delete(Integer id);
}
