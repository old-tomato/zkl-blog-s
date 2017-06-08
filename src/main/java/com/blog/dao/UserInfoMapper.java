package com.blog.dao;

import com.blog.model.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 52426 on 2017/6/8.
 */
@Component
public interface UserInfoMapper {
    List<UserInfo> query();
    void insertNewUser(UserInfo userInfo);
}
