package com.补充;

import java.text.SimpleDateFormat;
import java.util.Date;
/*getday()  获取当前星期(0-6)
getDate() 获取当月几号（1-31）
getMonth（）获取是几月（0-11）
getFullYear()获取完整月份
 */
public class Data2 {
    public static void main(String[] args) {
        String[]arr ={"周日","周一","周二","周三","周四","周五","周六"};
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MMMdd号 HH:mm:ss"+"  "+arr[date.getDay()]);
        String format = simpleDateFormat.format(date);

        System.out.println(format);


    }
}
