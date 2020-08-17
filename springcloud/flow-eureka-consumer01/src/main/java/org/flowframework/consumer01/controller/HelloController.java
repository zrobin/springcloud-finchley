package org.flowframework.consumer01.controller;

import org.flowframework.consumer01.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 */

@RestController
@RequestMapping(value = "/hello", produces = "application/json")
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name) {
        return helloService.hello(name) + ", response port: 8781";
    }

    // 调用consumer02服务
    @RequestMapping(value = "/consumer/{name}", method = RequestMethod.GET)
    public String consumer(@PathVariable("name") String name) {
        return helloService.consumer(name) + ", response port: 8781";
    }
}
