package com.blog.common;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * Created by 52426 on 2017/6/8.
 */
public class DataMessage<T> {
    /**
     * 服务器中的错误
     */
    public static final int CODE_SERVER_ERROR = 1;
    /**
     * COOKIE安全校验错误
     */
    public static final int CODE_COOKIE_ERROR = 2;
    /**
     * 普通的服务器逻辑处理中的异常问题
     */
    public static final int CODE_ERROR = -1;

    /**
     * 成功
     */
    public static final int CODE_SUCCESS = 200;

    private int code;
    private String message;
    private T data;

    /**
     * 默认情况下成功的返回
     * @param message
     */
    public DataMessage(String message , T data) {
        this.code = CODE_SUCCESS;
        this.message = message;
        this.data = data;
    }

    public DataMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public DataMessage(T data) {
        this.code = CODE_SUCCESS;
        this.message = "success";
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
