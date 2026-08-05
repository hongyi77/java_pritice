package com.补充;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Data1 {
    public static void main(String[] args) {
        //需求2：定义任意两个Date对象，比较哪个时间在前，那个时间在后
        Random random = new Random();
        //创建两个时间对象
        //1.创建第一个时间对象，要求随机数为绝对值
        Date date = new Date(Math.abs(random.nextInt()));
        long time = date.getTime();
        System.out.println(date);
        Date date1 = new Date(Math.abs(random.nextInt()));
        long time1 = date1.getTime();
        System.out.println(date1);
        if (time>time1){
            System.out.println("第一个对象时间比较晚");
        }else if (time1>time){
            System.out.println("第二个对象时间比较晚");
        }else {
            System.out.println("两个时间一样");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

    private static void extracted() {//该方法为需求1
        Date date = new Date(0);
        System.out.println(date);
        //获取date的时间毫秒值
        long time = date.getTime();
        //在这个基础上我们加一年的毫秒值即可
        time = time+1000L*60*60*24*365;
        //把计算之后的时间毫秒值，在设置date当中
        date.setTime(time);
        System.out.println(date);
    }
}
