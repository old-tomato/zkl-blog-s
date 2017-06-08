package com.blog.controller;

import com.blog.dao.UserInfoMapper;
import com.blog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private UserInfoMapper userInfoMapper;

    @RequestMapping(value = "/checkInfo" , method = RequestMethod.POST)
    @ResponseBody
    public UserInfo login(@RequestBody UserInfo userInfo){
        UserInfo ui = new UserInfo();
        ui.setUid(0);
        ui.setUsername("zzz");
        ui.setPassword("66666");
        userInfoMapper.insertNewUser(ui);
        return userInfo;
    }
}
