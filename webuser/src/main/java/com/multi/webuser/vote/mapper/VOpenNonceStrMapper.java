package com.multi.webuser.vote.mapper;


import com.multi.webuser.vote.entity.VOpenNonceStr;
import com.multi.webuser.vote.entity.VOpenNonceStrExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VOpenNonceStrMapper {
    int countByExample(VOpenNonceStrExample example);

    int deleteByExample(VOpenNonceStrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VOpenNonceStr record);

    int insertSelective(VOpenNonceStr record);

    List<VOpenNonceStr> selectByExample(VOpenNonceStrExample example);

    VOpenNonceStr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VOpenNonceStr record, @Param("example") VOpenNonceStrExample example);

    int updateByExample(@Param("record") VOpenNonceStr record, @Param("example") VOpenNonceStrExample example);

    int updateByPrimaryKeySelective(VOpenNonceStr record);

    int updateByPrimaryKey(VOpenNonceStr record);
}