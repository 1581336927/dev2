package com.hcy.dao;

import com.hcy.entity.TbNote;
import com.hcy.entity.TbNoteType;
import com.hcy.entity.TbNoteTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TbNoteTypeMapper {
    long countByExample(TbNoteTypeExample example);

    int deleteByExample(TbNoteTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbNoteType record);

    int insertSelective(TbNoteType record);

    List<TbNoteType> selectByExample(TbNoteTypeExample example);

    TbNoteType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbNoteType record, @Param("example") TbNoteTypeExample example);

    int updateByExample(@Param("record") TbNoteType record, @Param("example") TbNoteTypeExample example);

    int updateByPrimaryKeySelective(TbNoteType record);

    int updateByPrimaryKey(TbNoteType record);

    List<TbNoteType> selectType(@Param("id")Integer id);

    List<TbNote> selectNoteById(@Param("id") Integer id);
}