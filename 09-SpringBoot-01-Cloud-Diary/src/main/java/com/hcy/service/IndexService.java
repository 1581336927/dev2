package com.hcy.service;

import com.github.pagehelper.PageInfo;
import com.hcy.entity.TbNote;
import com.hcy.vo.NoteVO;

import java.util.List;

public interface IndexService {
    PageInfo<TbNote> page(Integer pageNum, Integer pageSize, Integer userId, Integer typeId, String title, String date);

    List<NoteVO> findCountByDate(Integer id);

    List<NoteVO> findCountByType(Integer id);
}
