package com.blog.service;

import com.blog.dao.user.UserCookieMapper;
import com.blog.dao.user.UserInfoMapper;
import com.blog.model.UserCookieInfo;
import com.blog.model.UserInfo;
import com.blog.utils.BlogSecurityUtils;
import com.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by 52426 on 2017/6/8.
 */
@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserCookieMapper userCookieMapper;

    private BlogSecurityUtils blogSecurityUtils = new BlogSecurityUtils();

    /**
     * 注册
     * @param userInfo
     * @return 返回新用户的COOKIE
     */
    public String singIn(UserInfo userInfo){
        // 查询当前的用户名称是否已经被使用过了
        String existUsername = userInfoMapper.queryUsernameRepeat(userInfo.getUsername());
        if(!StringUtils.isEmpty(existUsername)){
            return "";
        }
        // 对于密码进行一次MD5的处理
        userInfo.setPassword(MD5Utils.getM5Code(userInfo.getPassword()));
        // 创建该用户的UID
        userInfo.setUid(blogSecurityUtils.createUid());
        userInfoMapper.insertNewUser(userInfo);

        // 创建用户的COOKIE
        String cookie = blogSecurityUtils.createCookie(userInfo.getUid());
        UserCookieInfo cookieInfo = new UserCookieInfo(userInfo.getUid() , cookie);
        userCookieMapper.insert(cookieInfo);
        return cookie;
    }
}
