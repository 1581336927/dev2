package com.hcy.dao;

import com.hcy.entity.TbMusic;
import com.hcy.entity.TbSheet;
import com.hcy.entity.TbSheetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TbSheetMapper {
    long countByExample(TbSheetExample example);

    int deleteByExample(TbSheetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSheet record);

    int insertSelective(TbSheet record);

    List<TbSheet> selectByExample(TbSheetExample example);

    TbSheet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSheet record, @Param("example") TbSheetExample example);

    int updateByExample(@Param("record") TbSheet record, @Param("example") TbSheetExample example);

    int updateByPrimaryKeySelective(TbSheet record);

    int updateByPrimaryKey(TbSheet record);

    List<TbMusic> findSongsBySheet(@Param("sheetName") String sheetName);
}