package org.flowframework.config.client02.controller;

import org.flowframework.config.client02.config.RefreshConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 *
 * 读取配置文件, 并支持自动刷新
 */

@RestController
public class ConfigController {

    @Autowired
    RefreshConfig refreshConfig;

    @RequestMapping("/config")
    public Object getConfig() {
        return refreshConfig.getConfig();
    }
}
