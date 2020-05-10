package com.learning.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述：
 *  路由之前的过滤器
 * @author morning
 * @date 2020/4/30 17:09
 * @version v0.0.1
 */
public class PreFilter extends ZuulFilter {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PreFilter.class);

    /**
      * 功能描述:
      *  该过滤器在路由之前调用
      * @author morning
      * @date 2020/4/30 17:11
      * @version v0.0.1
      * @return  String
      */
    @Override
    public String filterType() {
        LOGGER.info("PreFilter Type");
        return FilterConstants.PRE_TYPE;
    }

    /**
      * 功能描述:
      *  确定过滤器的执行顺序，0表示最高,数字越大优先级越低
      * @author morning
      * @date 2020/4/30 17:12
      * @version v0.0.1
      * @return  int
      */
    @Override
    public int filterOrder() {
        LOGGER.info("PreFilter Order:" + 0);
        return 0;
    }

    /**
      * 功能描述:
      *  是否开启过滤器
      * @author yt.wei
      * @date 2020/4/30 17:16
      * @version v0.0.1
      * @return  boolean
      */
    @Override
    public boolean shouldFilter() {
        LOGGER.info("PreFilter shouldFilter:" + true);
        return true;
    }

    /**
     * 功能描述：
     *  执行过滤器
     * @author yt.wei
     * @date 2020/4/30 17:17
     * @version v0.0.1
     */
    @Override
    public Object run() throws ZuulException {
        LOGGER.info("Start Call PreFilter......");
        LOGGER.info("PreFilter order is 0");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        LOGGER.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        LOGGER.info("End Call PreFilter......");
        return null;
    }
}
