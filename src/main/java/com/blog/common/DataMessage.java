package com.blog.common;

/**
 * Created by 52426 on 2017/6/8.
 */
public class DataMessage<T> {

    private int code;
    private String message;
    private T result;

    /**
     * 默认情况下成功的返回
     * @param message
     */
    public DataMessage(String message , T result) {
        this.code = DataCodeConstants.CODE_SUCCESS;
        this.message = message;
        this.result = result;
    }

    public DataMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public DataMessage(T result) {
        this.code = DataCodeConstants.CODE_SUCCESS;
        this.message = "success";
        this.result = result;
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
