package com.multi.webapi.clientbreak;

import com.multi.webapi.Interface.VoteService;
import com.multi.webcommon.model.CodeMessageEnum;
import com.multi.webcommon.model.ServerResult;
import org.springframework.stereotype.Component;

/**
 * Description:feign断路器
 *
 * @author lpfei
 * Date: 2019-03-07
 */
@Component
public class VoteServiceHystric implements VoteService {
    @Override
    public Object index() {
        return ServerResult.error(CodeMessageEnum.ERROR);
    }

    @Override
    public Object list() {
        return ServerResult.error(CodeMessageEnum.ERROR);
    }

    @Override
    public Object doVote(Integer id) {
        return ServerResult.error(CodeMessageEnum.ERROR);
    }

    @Override
    public Object detail(Integer id) {
        return ServerResult.error(CodeMessageEnum.ERROR);
    }
}
