package com.multi.webuser.user.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author lpfei
 * Date: 2019-03-05
 */
@RestController
public class UserController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public Object home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
