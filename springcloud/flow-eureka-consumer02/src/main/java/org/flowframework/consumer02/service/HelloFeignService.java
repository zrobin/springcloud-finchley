package org.flowframework.consumer02.service;

import org.flowframework.consumer02.config.ServiceError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 *
 * Feign接口
 */

@FeignClient(value = "eureka-provider", fallback = ServiceError.class)
public interface HelloFeignService {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String hello(@PathVariable("name") String name);
}
