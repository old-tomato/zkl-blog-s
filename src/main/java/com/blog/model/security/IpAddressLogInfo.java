package com.blog.model.security;

import java.time.LocalDateTime;

/**
 * Created by 52426 on 2017/6/13.
 */
public class IpAddressLogInfo {

    private int id;
    private String ip;
    private LocalDateTime createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
