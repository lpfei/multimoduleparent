package com.multi.webuser.vote.service;

import com.multi.webcommon.util.NullUtil;
import com.multi.webcommon.util.UUIDUtil;
import com.multi.webuser.vote.entity.VOpenNonceStr;
import com.multi.webuser.vote.entity.VOpenNonceStrExample;
import com.multi.webuser.vote.mapper.VOpenNonceStrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-11-12
 * Time: 9:22
 */
@Service
public class VOpenNonceStrService {
    @Autowired
    private VOpenNonceStrMapper vOpenNonceStrMapper;

    public VOpenNonceStr selectByOpenId(String openId) {
        VOpenNonceStrExample example = new VOpenNonceStrExample();
        example.createCriteria().andOpenIdEqualTo(openId);
        List<VOpenNonceStr> list = vOpenNonceStrMapper.selectByExample(example);
        return NullUtil.isNotEmpty(list) ? list.get(0) : null;
    }

    @Async
    public void insertVOpenNonceStr(String openId) {
        try {
            VOpenNonceStr nonceStr = new VOpenNonceStr();
            nonceStr.setOpenId(openId);
            nonceStr.setNonceStr(UUIDUtil.randomUUID());
            vOpenNonceStrMapper.insertSelective(nonceStr);
        } catch (Exception e) {

        }
    }
}
