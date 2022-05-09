package com.hcy.dao;

import com.hcy.entity.TbNote;
import com.hcy.vo.NoteVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {
    List<NoteVO> getNoteCountByMonth(Integer id);

    List<TbNote> getLocation(Integer id);
}
