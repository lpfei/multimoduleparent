package com.multi.webcommon.util;

import java.util.UUID;

/**
 * Created by zhuxh on 2017/12/23.
 */
public class UUIDUtil {
    /**
     * 生成uuid随机数
     * @return
     */
    public static String randomUUID(){
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(randomUUID());
    }
}
