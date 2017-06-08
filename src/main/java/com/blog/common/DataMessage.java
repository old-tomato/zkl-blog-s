package com.blog.common;

/**
 * Created by 52426 on 2017/6/8.
 */
public class DataMessage {
    /**
     * 服务器中的错误
     */
    public static final int CODE_SERVER_ERROR = 1;
    /**
     * COOKIE安全校验错误
     */
    public static final int CODE_COOKIE_ERROR = 2;

    /**
     * 成功
     */
    public static final int CODE_SUCCESS = 200;

    private int code;
    private String message;

    /**
     * 默认情况下成功的返回
     * @param message
     */
    public DataMessage(String message) {
        this.code = CODE_SUCCESS;
        this.message = message;
    }

    public DataMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
