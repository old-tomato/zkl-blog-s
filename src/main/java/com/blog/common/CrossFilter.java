package com.blog.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 52426 on 2017/6/7.
 */
public class CrossFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse r = (HttpServletResponse) response;
        // 指代从任何地址过来的网址都是可以接受的
        r.setHeader("Access-Control-Allow-Origin","*");
        // 指允许接受的几种方法
        r.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
        r.setHeader("Access-Control-Max-Age","3600");
        // 可以接受的头信息，最后一个是我自己加上去的
        r.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Z-Blog-Cookie");
        chain.doFilter(request, r);
    }

    @Override
    public void destroy() {

    }
}
