package com.blog.service;

import com.blog.dao.user.UserCookieMapper;
import com.blog.dao.user.UserInfoMapper;
import com.blog.exception.ServiceException;
import com.blog.model.UserCookieInfo;
import com.blog.model.UserInfo;
import com.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private BlogSecurityService blogSecurityService;

    /**
     * 注册
     * @param userInfo
     * @return 返回新用户的COOKIE
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public String register(UserInfo userInfo){
        checkUserInfoAvailable(userInfo);
        // 查询当前的用户名称是否已经被使用过了
        String existUsername = userInfoMapper.queryUsernameRepeat(userInfo.getUsername());
        if(!StringUtils.isEmpty(existUsername)){
            throw new ServiceException("存在相同的用户名");
        }
        // 对于密码进行一次MD5的处理
        userInfo.setPassword(MD5Utils.getM5Code(userInfo.getPassword()));
        // 创建该用户的UID
        userInfo.setUid(blogSecurityService.createUid());
        userInfoMapper.insertNewUser(userInfo);

        // 创建用户的COOKIE
        String cookie = blogSecurityService.createCookie(userInfo.getUid());
        UserCookieInfo cookieInfo = new UserCookieInfo(userInfo.getUid() , cookie);
        userCookieMapper.insert(cookieInfo);
        return cookie;
    }

    private void checkUserInfoAvailable(UserInfo userInfo) {
        if(StringUtils.isEmpty(userInfo.getUsername()) ||
                StringUtils.isEmpty(userInfo.getPassword()) ||
                StringUtils.isEmpty(userInfo.getMailAddress())){
            throw new ServiceException("信息不完整");
        }
    }

    public UserInfo login(UserInfo userInfo) {
        // 密码进行一次加密
        userInfo.setPassword(MD5Utils.getM5Code(userInfo.getPassword()));
        UserInfo dbUserInfo = userInfoMapper.queryOneUser(userInfo);
        if(dbUserInfo != null){
            dbUserInfo.setPassword("");
            return dbUserInfo;
        }else{
            throw new ServiceException("用户名或者密码错误");
        }
    }

    public UserInfo loginWithCookie(UserInfo userInfo){
        Integer uid = userCookieMapper.getUid(userInfo.getCookie());
        if(uid == null || uid == 0){
            return null;
        }
        UserInfo logUser = userInfoMapper.queryByUid(uid);
        return logUser;
    }

}
