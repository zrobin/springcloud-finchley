package org.flowframework.consumer02.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 *
 * Feign接口, 调用consumer01服务
 */

@FeignClient(value = "eureka-consumer-ribbon")
public interface ConsumerFeignService {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String consumer(@PathVariable("name") String name);
}
