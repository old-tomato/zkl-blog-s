package com.blog.model;

import java.time.LocalDateTime;

/**
 * Created by 52426 on 2017/6/9.
 */
public class UserCookieInfo {

    private int uid;
    /**
     * cookie的有效时间时7天时间，同时每一次登陆成功，都将会更新cookie
     */
    private String cookie;
    private LocalDateTime create_time;
    private LocalDateTime available_time;

    public UserCookieInfo(int uid, String cookie) {
        this.uid = uid;
        this.cookie = cookie;
    }

    public UserCookieInfo() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getAvailable_time() {
        return available_time;
    }

    public void setAvailable_time(LocalDateTime available_time) {
        this.available_time = available_time;
    }
}
