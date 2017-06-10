package com.blog.common;

import com.blog.dao.user.UserCookieMapper;
import com.blog.exception.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by 52426 on 2017/6/8.
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    Logger logger = Logger.getLogger(this.getClass().getName());
    private static final String ZBLOG_HEAD = "Z-Blog-Cookie";

    @Autowired
    private UserCookieMapper userCookieMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        getHeadersInfo(request);
        //这里做统一的COOKIE校验
        // 对于登陆以及注册的接口不校验COOKIE
        logger.info(request.getRequestURI());
        String requestURI = request.getRequestURI();
        if(requestURI.equals("/login/login") || requestURI.equals("/login/regist")){
            return true;
        }else{
            // 校验COOKIE，如果校验失败，就需要界面返回到登陆界面
            return checkCookie(request, response);
        }
    }

    private boolean checkCookie(HttpServletRequest request, HttpServletResponse response) {
        String cookie = request.getHeader(ZBLOG_HEAD);
        if(StringUtils.isEmpty(cookie)){
            // 返回登陆界面
            throw new ServiceException("auto login failed");
        }
        // 请求数据库返回的数据
        Integer uid = userCookieMapper.getUid(cookie);
        if(uid == null || uid == 0){
            throw new ServiceException("auto login failed");
        }
        return true;
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
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
