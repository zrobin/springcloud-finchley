package org.flowframework.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 *
 * zuul过滤器
 */

@Component
public class FilterConfig extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(FilterConfig.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("方法: %s, 地址: %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(null == accessToken) {
            logger.error("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            logger.info("token: " + accessToken);
        }
        return null;
    }
}
