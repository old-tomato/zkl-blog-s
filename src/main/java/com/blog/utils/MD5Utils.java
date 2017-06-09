package com.blog.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 52426 on 2017/6/9.
 */
public class MD5Utils {

    public static String getM5Code(String originWord){
        try{
            //确定计算方法
            MessageDigest md5= MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String md5Code=base64en.encode(md5.digest(originWord.getBytes("utf-8")));
            return md5Code;
        }catch (Exception e){
            e.printStackTrace();
            return originWord;
        }
    }

}
