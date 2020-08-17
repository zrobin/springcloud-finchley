package org.flowframework.consumer01.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.flowframework.consumer01.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 *
 * 使用断路器Hystrix, 服务不可用时会执行熔断方法, 快速失败
 */

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @Override
    public String hello(String name) {
        return restTemplate.getForObject("http://eureka-provider/hello/" + name, String.class);
    }

    // 调用consumer02服务
    @Override
    public String consumer(String name) {
        return restTemplate.getForObject("http://eureka-consumer-feign/hello/feign/" + name, String.class);
    }

    public String error(String name) {
        return "service error";
    }
}
