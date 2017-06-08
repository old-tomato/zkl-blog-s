package com.blog.controller;

import java.util.logging.Logger;

/**
 * Created by 52426 on 2017/5/27.
 */
public class TestController {

    public A loginPage() {
        Logger logger = Logger.getLogger("zkl");
        logger.info("login!!!!!!!!!!sadadasdasdasdsdasd!!!!!");
        A a = new A();
        a.setName("zkl");
        // where have a error named 406啊啊
        return a;
    }

    private class A{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
