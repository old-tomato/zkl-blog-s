package com.blog.dao.user;

import com.blog.model.UserCookieInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 52426 on 2017/6/9.
 */
public interface UserCookieMapper {
    Integer getUid(@Param("cookie") String cookie);
    void insert(UserCookieInfo userCookieInfo);
    int updateCookie(@Param("uid")int uid, @Param("cookie")String cookie);
    String queryCookie(@Param("uid")int uid);
}
