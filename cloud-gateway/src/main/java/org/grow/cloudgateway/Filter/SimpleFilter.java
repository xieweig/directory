package org.grow.cloudgateway.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Author : xieweig
 * Date : 18-7-16
 * <p>
 * Description:
 */
@Component
public class SimpleFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return  "pre";
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

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        System.err.println(request);
        //if (StringUtils.isEmpty(request.getHeader("token"))) throw new RuntimeException("过滤器中断请求访问服务器");


        return null;
    }
}
