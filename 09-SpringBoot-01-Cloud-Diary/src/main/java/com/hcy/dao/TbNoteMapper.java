package com.hcy.dao;

import com.hcy.entity.TbNote;
import com.hcy.entity.TbNoteExample;
import java.util.List;

import com.hcy.vo.NoteVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TbNoteMapper {
    long countByExample(TbNoteExample example);

    int deleteByExample(TbNoteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbNote record);

    int insertSelective(TbNote record);

    List<TbNote> selectByExampleWithBLOBs(TbNoteExample example);

    List<TbNote> selectByExample(TbNoteExample example);

    TbNote selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbNote record, @Param("example") TbNoteExample example);

    int updateByExampleWithBLOBs(@Param("record") TbNote record, @Param("example") TbNoteExample example);

    int updateByExample(@Param("record") TbNote record, @Param("example") TbNoteExample example);

    int updateByPrimaryKeySelective(TbNote record);

    int updateByPrimaryKeyWithBLOBs(TbNote record);

    int updateByPrimaryKey(TbNote record);

    List<TbNote> findNoteByUserId(@Param("userId") Integer userId, @Param("typeId") Integer typeId, @Param("title") String title, @Param("date") String date);

    //根据用户的id获取分类的日期
    List<NoteVO> findCountByType(Integer userId);
    //根据用户的id获取分类的类别
    List<NoteVO> findCountByDate(Integer userId);

    //跟据id获取对应的日记对象
    NoteVO findById(Integer id);
}