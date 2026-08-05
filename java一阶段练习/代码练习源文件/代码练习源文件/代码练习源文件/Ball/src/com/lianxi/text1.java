package com.lianxi;

import java.util.Calendar;
import java.util.Date;


public class text1 {
  public static void main(String[] args) {
      //通过这个你可以知道此时的具体时间
    Date java1 = new Date();
      System.out.println(java1.getTime());
      System.out.println(java1.toString());
      //汉语版的时间
      Calendar cal =  Calendar.getInstance();
      System.out.print(cal.get(cal.YEAR)+"年");
      System.out.print((cal.get(cal.MONTH)+1)+"月");
      System.out.print((cal.get(cal.DAY_OF_MONTH))+"日,");
      System.out.print("星期"+(cal.get(cal.DAY_OF_WEEK)-1)+",");
      if (cal.get(cal.HOUR_OF_DAY)>12) {
           int ge=cal.get(cal.HOUR_OF_DAY)-12;
          System.out.print("此时为下午"+ge+"时");

      } else if (cal.get(cal.HOUR_OF_DAY)<12) {
          System.out.print("此时为上午"+cal.get(cal.HOUR_OF_DAY));
      }else {
          System.out.print("此事为中午"+cal.get(cal.HOUR_OF_DAY));
      }

      System.out.print(cal.get(cal.MINUTE)+"分");
      System.out.print(cal.get(cal.SECOND)+"秒");
      System.out.println(cal.get(cal.MILLISECOND)+"毫秒");
      System.out.println("这是在二月份的第"+(cal.get(cal.WEEK_OF_MONTH)-1)+"周的第"+(cal.get(cal.DAY_OF_WEEK)-1)+"天");
      /* if (cal.get(cal.HOUR_OF_DAY)>12) {
           System.out.println("此时为下午");
       } else if (cal.get(cal.HOUR_OF_DAY)<12) {
           System.out.println("此时为上午");
       }else {
           System.out.println("此事为中午");
       }*/


  }
}
