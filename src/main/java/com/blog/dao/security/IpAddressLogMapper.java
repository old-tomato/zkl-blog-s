package com.blog.dao.security;

import org.apache.ibatis.annotations.Param;

/**
 * Created by 52426 on 2017/6/13.
 */
public interface IpAddressLogMapper {
    void insertUserIp(@Param("ip")String ip);
}
