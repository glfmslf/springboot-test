package com.yy.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: youyu  工号：S37565
 * 自定义路由过滤器，实现ZuulFilter类
 * CREATED_DATE: 2018/7/19 17:22
 */
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
//        表示过滤器类型，pre在路由之前过滤，routing在路由时过滤，post在路由之后，error发送错误时调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        //该条规则的优先级，数字越大优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
//        是否执行该过滤器，false：不执行，true：执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        System.out.println("ok");
        return null;

    }
}
