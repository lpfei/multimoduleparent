package com.multi.webuser.vote.service;

import com.multi.webcommon.constants.PUBConstants;
import com.multi.webcommon.model.PageModel;
import com.multi.webcommon.model.ServiceResult;
import com.multi.webcommon.util.PageUtil;
import com.multi.webuser.vote.entity.VJoinUser;
import com.multi.webuser.vote.entity.VJoinUserExample;
import com.multi.webuser.vote.entity.VVoteLog;
import com.multi.webuser.vote.entity.VVoteLogExample;
import com.multi.webuser.vote.mapper.VJoinUserMapper;
import com.multi.webuser.vote.mapper.VVoteLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-11-10
 * Time: 22:00
 */
@Service
public class VoteService {
    @Autowired
    private VVoteLogMapper vVoteLogMapper;
    @Autowired
    private VJoinUserMapper vJoinUserMapper;


    public VJoinUser selectByPrimaryKey(Integer id) {
        return vJoinUserMapper.selectByPrimaryKey(id);
    }

    public List<VJoinUser> allList() {
        VJoinUserExample example = new VJoinUserExample();
        example.setOrderByClause("votes desc,id asc");
        return vJoinUserMapper.selectByExample(example);
    }


    public List<VJoinUser> maxVotesList() {
        PageModel pageModel = PageUtil.initPageModel();
        pageModel.setPageSize(4);
        VJoinUserExample example = new VJoinUserExample();
        example.setOrderByClause("votes desc,id asc");
        example.setPageModel(pageModel);
        return vJoinUserMapper.selectByExample(example);
    }

    public Integer countVotes() {
        VVoteLogExample example = new VVoteLogExample();
        return vVoteLogMapper.countByExample(example);
    }

    public Integer countJoinUser() {
        VJoinUserExample example = new VJoinUserExample();
        return vJoinUserMapper.countByExample(example);
    }

    public int selectVoteLogByOpenId(String openId) {
        /*VVoteLogExample example = new VVoteLogExample();
        example.createCriteria().andOpenIdEqualTo(openId).andCreateTimeGreaterThanOrEqualTo(new JDateTime(new JDateTime().toString(PUBConstants.DEFAULT_DATE_FORMAT_FRONT_STAMP)).convertToDate());
        return vVoteLogMapper.countByExample(example);*/
        return 1;
    }

    public ServiceResult addVotes(String openId, Integer id) throws Exception {
        /*VJoinUser user = selectByPrimaryKey(id);
        Date currDate = new JDateTime().convertToDate();
        Map<String, Object> time = commonXmlMapper.getActivityTime();
        if (currDate.getTime() < new JDateTime(time.get("start_time").toString()).getTimeInMillis()) {
            return OperationResult.error("投票还未开始");
        } else if (currDate.getTime() > new JDateTime(time.get("end_time").toString()).addDay(1).getTimeInMillis()) {
            return OperationResult.error("投票已结束");
        }
        if (user == null) {
            return OperationResult.error("用户不存在");
        }
        if (selectVoteLogByOpenId(openId) > 0) {
            return OperationResult.error("今天您已投票,请明天投票");
        }
        vJoinUserMapper.addVotes(id);
        VVoteLog log = new VVoteLog();
        log.setCreateTime(new Date());
        log.setJoinUserId(id);
        log.setOpenId(openId);
        vVoteLogMapper.insertSelective(log);*/
        return ServiceResult.success();
    }
}
