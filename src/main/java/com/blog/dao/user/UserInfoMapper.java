package com.blog.dao.user;

import com.blog.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 52426 on 2017/6/8.
 */
@Component
public interface UserInfoMapper {
    List<UserInfo> query();
    void insertNewUser(UserInfo userInfo);
    String queryUsernameRepeat(@Param("username")String username);
}
