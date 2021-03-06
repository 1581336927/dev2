package com.hcy.dao;

import com.hcy.entity.TbUser;
import com.hcy.entity.TbUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper {
    long countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    TbUser select(@Param("username") String username,@Param("password")String password);

    Integer update(@Param("nick")String nick,@Param("mood")String mood,@Param("id")Integer id);

    Integer updateImg(@Param("head")String head,@Param("id")Integer id);

    List<TbUser> selectNick(@Param("nick")String nick);
}