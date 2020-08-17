package org.flowframework.consumer02.controller;

import org.flowframework.consumer02.service.ConsumerFeignService;
import org.flowframework.consumer02.service.HelloFeignService;
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
    HelloFeignService helloFeignService;
    @Autowired
    ConsumerFeignService consumerFeignService;

    @RequestMapping(value = "/feign/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name) {
        return helloFeignService.hello(name) + ", response port: 8782";
    }

    // 调用consumer01服务
    @RequestMapping(value = "/consumer/{name}", method = RequestMethod.GET)
    public String consumer(@PathVariable("name") String name) {
        return consumerFeignService.consumer(name) + ", response port: 8782";
    }
}
