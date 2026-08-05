package com.补充;

import java.util.Date;

public class Data {
    public static void main(String[] args) {
        //创建一个对象表示对象
        Date date = new Date();
        System.out.println(date);
        //创建一个指定的对象
        Date date1 = new Date(1000L);
        System.out.println(date1);
        long time = date1.getTime();
        System.out.println(time);
    }
}
