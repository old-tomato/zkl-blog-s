package com.blog.controller;

import com.blog.common.DataCodeConstants;
import com.blog.common.DataMessage;
import com.blog.exception.ServiceException;
import com.blog.model.UserInfo;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 52426 on 2017/6/7.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    @ResponseBody
    public DataMessage<UserInfo> login(@RequestBody UserInfo userInfo){
        UserInfo loginUserInfo = userService.login(userInfo);
        return new DataMessage<UserInfo>(loginUserInfo);
    }

    @RequestMapping(value = "/autoLogin" , method = RequestMethod.POST)
    @ResponseBody
    public DataMessage<UserInfo> autoLogin(@RequestBody UserInfo userInfo){
        UserInfo logUserInfo = userService.loginWithCookie(userInfo);
        if(logUserInfo == null){
            throw new ServiceException("auto login failed");
        }
        return new DataMessage<UserInfo>(logUserInfo);
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public DataMessage<String> regist(@RequestBody UserInfo userInfo){
        // 注册完成以后，返回COOKIE，然后进行登陆流程
        String cookie = userService.register(userInfo);
        return new DataMessage<String>(cookie);
    }

    @RequestMapping(value = "/welcome")
    @ResponseBody
    public DataMessage welcome(){
        return DataMessage.SUCCESS;
    }

}
