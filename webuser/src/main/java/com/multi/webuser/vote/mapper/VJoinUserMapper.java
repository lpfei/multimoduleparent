package com.multi.webuser.vote.mapper;


import com.multi.webuser.vote.entity.VJoinUser;
import com.multi.webuser.vote.entity.VJoinUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VJoinUserMapper {
    int countByExample(VJoinUserExample example);

    int deleteByExample(VJoinUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VJoinUser record);

    int insertSelective(VJoinUser record);

    List<VJoinUser> selectByExample(VJoinUserExample example);

    VJoinUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VJoinUser record, @Param("example") VJoinUserExample example);

    int updateByExample(@Param("record") VJoinUser record, @Param("example") VJoinUserExample example);

    int updateByPrimaryKeySelective(VJoinUser record);

    int updateByPrimaryKey(VJoinUser record);

    int addVotes(Integer id);
}