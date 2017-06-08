package com.blog.common;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by 52426 on 2017/6/8.
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        这里做统一的COOKIE校验
        logger.info("pre handle");
//        getHeadersInfo(request);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=utf-8");
//
//        PrintWriter writer = response.getWriter();
//        ObjectMapper om = new ObjectMapper();
//        String error = om.writer().writeValueAsString(new DataMessage("error!!!!"));
//        writer.append(error);
//        writer.close();
        return super.preHandle(request, response, handler);
//        return true;
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
            logger.info("key ==> " + key + "  value ==> " + value);
        }
        return map;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("post handle");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("after completion");

        super.afterCompletion(request, response, handler, ex);
    }
}
