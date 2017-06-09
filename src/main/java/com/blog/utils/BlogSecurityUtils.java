package com.blog.utils;

import com.blog.dao.security.UidQueueMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Created by 52426 on 2017/6/9.
 */
public class BlogSecurityUtils {

    @Autowired
    private UidQueueMapper uidQueueMapper;

    /**
     * 创建一个用户唯一的UID
     * @return
     */
    public int createUid(){
        int uid = uidQueueMapper.queryUid();
        uidQueueMapper.increaseUid();
        return uid;
    }

    public String createCookie(int uid){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        String s = uid + "" + System.currentTimeMillis() + random.nextInt();
        return MD5Utils.getM5Code(s);
    }

}
