package com.multi.serverconfigclient.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author lpfei
 * Date: 2019-03-07
 */
@RestController
@Slf4j
@RefreshScope
public class TestController {
    @Value("${server.port}")
    private String port;


    @Value("${spring.redis.timeout}")
    private String timeout;

    @RequestMapping(value = "test")
    public Object test() {
        return this.port;
    }


    @RequestMapping(value = "testRab")
    public Object testRab() {
        return this.timeout;
    }
}
