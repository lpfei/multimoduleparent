package com.multi.webapi.Interface;

import com.multi.webapi.clientbreak.VoteServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 *
 * @author lpfei
 * Date: 2019-03-05
 */
@FeignClient(value = "web-user-cli", fallback = VoteServiceHystric.class)
public interface VoteService {

    @RequestMapping(value = "vote/index", method = RequestMethod.GET)
    Object index();

    @RequestMapping(value = "vote/list", method = RequestMethod.GET)
    Object list();

    @RequestMapping(value = "vote/doVote/{id}", method = RequestMethod.POST)
    Object doVote(@PathVariable("id") Integer id);

    @RequestMapping(value = "/vote/detail/{id}", method = RequestMethod.GET)
    Object detail(@PathVariable(value = "id") Integer id);
}
