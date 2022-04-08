package com.hcy.dao;

import com.hcy.entity.Poor;
import com.hcy.entity.PoorExample;
import com.hcy.entity.PoorWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoorMapper {
    long countByExample(PoorExample example);

    int deleteByExample(PoorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PoorWithBLOBs record);

    int insertSelective(PoorWithBLOBs record);

    List<PoorWithBLOBs> selectByExampleWithBLOBs(PoorExample example);

    List<Poor> selectByExample(PoorExample example);

    PoorWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PoorWithBLOBs record, @Param("example") PoorExample example);

    int updateByExampleWithBLOBs(@Param("record") PoorWithBLOBs record, @Param("example") PoorExample example);

    int updateByExample(@Param("record") Poor record, @Param("example") PoorExample example);

    int updateByPrimaryKeySelective(PoorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PoorWithBLOBs record);

    int updateByPrimaryKey(Poor record);
}