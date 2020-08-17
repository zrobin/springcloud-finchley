package org.flowframework.consumer02.config;

import org.flowframework.consumer02.service.HelloFeignService;
import org.springframework.stereotype.Component;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 *
 * 熔断处理
 */

@Component
public class ServiceError implements HelloFeignService {

    @Override
    public String hello(String name) {
        return error(name);
    }

    public String error(String name) {
        return "service error";
    }
}
