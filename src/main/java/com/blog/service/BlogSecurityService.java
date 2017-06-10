package com.blog.service;

import com.blog.dao.security.UidQueueMapper;
import com.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by 52426 on 2017/6/10.
 */
@Service
public class BlogSecurityService {

    @Autowired
    private UidQueueMapper uidQueueMapper;

    /**
     * 创建一个用户唯一的UID
     * @return
     */
    public int createUid(){
        Integer uid = uidQueueMapper.queryUid();
        if(uid == null){
            uid = 0;
        }
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
