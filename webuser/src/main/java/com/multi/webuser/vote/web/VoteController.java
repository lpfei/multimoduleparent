package com.multi.webuser.vote.web;

import com.multi.webcommon.anno.SessionScope;
import com.multi.webcommon.constants.PUBConstants;
import com.multi.webcommon.model.ServiceResult;
import com.multi.webuser.vote.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-11-10
 * Time: 22:01
 */
@Slf4j
@RestController
public class VoteController {
    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "vote/index", method = RequestMethod.GET)
    public Object index(@SessionScope(PUBConstants.SESSION_OPEN_ID) String openId) {
        Map map = new HashMap<>();
        map.put("maxVotesList", voteService.maxVotesList());
        map.put("countVotes", voteService.countVotes());
        map.put("countJoinUser", voteService.countJoinUser());
        return ServiceResult.success(map);
    }

    @RequestMapping(value = "vote/list", method = RequestMethod.GET)
    public Object list(@SessionScope(PUBConstants.SESSION_OPEN_ID) String openId) {
        return ServiceResult.success(voteService.allList());
    }

    @RequestMapping(value = "vote/doVote/{id}", method = RequestMethod.POST)
    public Object doVote(@SessionScope(PUBConstants.SESSION_OPEN_ID) String openId, @PathVariable("id") Integer id) throws Exception {
        return voteService.addVotes(openId, id);
    }


    @RequestMapping(value = "vote/detail/{id}", method = RequestMethod.GET)
    public Object detail(@SessionScope(PUBConstants.SESSION_OPEN_ID) String openId, @PathVariable("id") Integer id) {
        Map map = new HashMap<>();
        map.put("model", voteService.selectByPrimaryKey(id));
        map.put("isVote", voteService.selectVoteLogByOpenId(openId));
        return ServiceResult.success(map);
    }
}
