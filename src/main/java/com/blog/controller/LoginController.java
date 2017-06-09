package com.blog.controller;

import com.blog.common.DataMessage;
import com.blog.dao.user.UserInfoMapper;
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

    @RequestMapping(value = "/checkInfo" , method = RequestMethod.POST)
    @ResponseBody
    public DataMessage<UserInfo> login(@RequestBody UserInfo userInfo){

        return new DataMessage<UserInfo>(userInfo);
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @ResponseBody
    public DataMessage<String> signIn(@RequestBody UserInfo userInfo){
        // 注册完成以后，返回COOKIE，然后进行登陆流程
        String cookie = userService.singIn(userInfo);
        if(StringUtils.isEmpty(cookie)){
            // 存在用户名重复的问题
            return new DataMessage<String>(DataMessage.CODE_ERROR , "用户名重复");
        }
        return new DataMessage<String>(cookie);
    }
}
