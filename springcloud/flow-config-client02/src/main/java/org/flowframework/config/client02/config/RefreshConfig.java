package org.flowframework.config.client02.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 */

@Component
@RefreshScope
public class RefreshConfig {

    @Value("${data.env}")
    private String env;
    @Value("${data.user.username}")
    private String username;
    @Value("${data.user.password}")
    private String password;

    public Map<String, Object> getConfig() {
        Map<String, Object> paramMap = new HashMap<>(3);
        paramMap.put("env", env);
        paramMap.put("username", username);
        paramMap.put("password", password);
        return paramMap;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
