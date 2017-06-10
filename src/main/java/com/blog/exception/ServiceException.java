package com.blog.exception;

/**
 * Created by 52426 on 2017/6/10.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}
