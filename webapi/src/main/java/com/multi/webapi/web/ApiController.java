package com.multi.webapi.web;

import com.multi.webapi.Interface.VoteService;
import com.multi.webcommon.anno.SessionScope;
import com.multi.webcommon.constants.PUBConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author lpfei
 * Date: 2019-03-05
 */
@RestController
@Slf4j
public class ApiController {
    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "vote/index", method = RequestMethod.GET)
    public Object index() {
        return voteService.index();
    }

    @RequestMapping(value = "vote/list", method = RequestMethod.GET)
    public Object list() {
        return voteService.list();
    }

    @RequestMapping(value = "vote/doVote/{id}", method = RequestMethod.POST)
    public Object doVote(@PathVariable("id") Integer id) {
        return voteService.doVote(id);
    }

    @RequestMapping(value = "/vote/detail/{openId}/{id}", method = RequestMethod.GET)
    public Object detail(@SessionScope(PUBConstants.SESSION_OPEN_ID) String openId, @PathVariable("id") Integer id) {
        return voteService.detail(id);
    }

}
