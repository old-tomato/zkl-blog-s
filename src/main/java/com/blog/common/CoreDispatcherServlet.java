package com.blog.common;

import com.blog.exception.ServiceException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by 52426 on 2017/6/10.
 */
public class CoreDispatcherServlet extends DispatcherServlet {

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doService(request, response);
    }

    @Override
    protected ModelAndView processHandlerException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        processException(request, response, ex);
        return null;
    }

    private void processException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        try {
            int code = 0;
            String message = null;
             if (ex instanceof ServiceException) {
                code = DataCodeConstants.CODE_ERROR;
                message = ex.getMessage();
            } else {
                code = DataCodeConstants.CODE_SERVER_ERROR;
                message = "服务器炸裂";
                logger.error(request.getServletPath() + " exception: ", ex);
            }

            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("utf-8");
            response.setHeader("Cache-Control","no-cache, must-revalidate");

            PrintWriter writer = response.getWriter();
            writer.write(String.format("{\"code\":%d,\"message\":\"%s\",\"result\":null}", code, message));
            writer.flush();

        } catch (Throwable e) {
            logger.error("error", e);
        }
    }
}
