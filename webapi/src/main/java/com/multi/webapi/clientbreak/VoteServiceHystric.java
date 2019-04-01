package com.multi.webapi.clientbreak;

import com.multi.webapi.Interface.VoteService;
import com.multi.webcommon.model.CodeMessageEnum;
import com.multi.webcommon.model.ServiceResult;
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
        return ServiceResult.error(CodeMessageEnum.error);
    }

    @Override
    public Object list() {
        return ServiceResult.error(CodeMessageEnum.error);
    }

    @Override
    public Object doVote(Integer id) {
        return ServiceResult.error(CodeMessageEnum.error);
    }

    @Override
    public Object detail(Integer id) {
        return ServiceResult.error(CodeMessageEnum.error);
    }
}
