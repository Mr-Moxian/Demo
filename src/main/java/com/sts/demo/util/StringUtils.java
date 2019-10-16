package com.sts.demo.util;

/**
 * String 相关公共类
 * */
public class StringUtils {

    public static boolean isEmpty(String str){
        return str == null ? true : (str.equals("") ? true : false);
    }

}
