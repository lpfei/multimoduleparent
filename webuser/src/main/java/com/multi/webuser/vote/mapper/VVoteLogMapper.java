package com.multi.webuser.vote.mapper;

import com.multi.webuser.vote.entity.VVoteLog;
import com.multi.webuser.vote.entity.VVoteLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VVoteLogMapper {
    int countByExample(VVoteLogExample example);

    int deleteByExample(VVoteLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VVoteLog record);

    int insertSelective(VVoteLog record);

    List<VVoteLog> selectByExample(VVoteLogExample example);

    VVoteLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VVoteLog record, @Param("example") VVoteLogExample example);

    int updateByExample(@Param("record") VVoteLog record, @Param("example") VVoteLogExample example);

    int updateByPrimaryKeySelective(VVoteLog record);

    int updateByPrimaryKey(VVoteLog record);
}