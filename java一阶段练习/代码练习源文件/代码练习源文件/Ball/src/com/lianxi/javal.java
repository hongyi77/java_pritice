package com.lianxi;

import java.util.Objects;

public class javal {
    public static void main(String[] args) {
        //compereto,比较两者ip地址的差
        String str1 = "apple";
        String str2 = "banana";
        int result = str1.compareTo(str2);
        System.out.println(result);
        System.out.println();
        //charAt，查看在第几位置所对应字符
        String str3 = "hello,world";
        char ch = str3.charAt(4);//charAt只能用char，若用字符串string会引起报错
        System.out.println(str3);//索引是从零开始的
        System.out.println("这个语句第三个字符为"+ch);
        System.out.println();
        //concat,具有合并两个字符的效果
        String str4 = "welcome"+" ";
        String str5 = "to chain";
        String result1 = str4.concat(str5);
        System.out.println(result1);
        System.out.println();
       /* System.out.println(str4);
        System.out.println(str5);*/
        //String,定义String的数据中所储存的数据
        String s = "hello";
        String s1  ="hello";
        String s2 = new String("hello");//与上面String同理
        String s3 = "hElLo";
        //equal,定义两个数组中的数据是否相等
        boolean isequal = s.equals(s1);
        System.out.println("s和s1是否相等:"+isequal);
        boolean isequal1 = s.equals(s2);
        System.out.println("s和s2是否相等:"+isequal1);
        boolean isequal2 = s.equals(s3);
        System.out.println("s和s3是否相等:"+isequal2);
        boolean isequal3 = s.equals(null);
        System.out.println("s和null是否相等"+isequal3);
        boolean isequal4 = Objects.equals(s,s1);
        System.out.println("s和s1使用Objects类比较是否相等:"+isequal4);
        System.out.println();
        //输出一个语句，用indexof看该字符在一整个字符串的第几位置,因为第一个字符默认零，所以后续需要在索引处加1
        String s5 = "hello,world!this is a java progrem.";
        int index = s5.indexOf('o')+1;
        System.out.println(s5+"   "+"o在第"+(index)+"位");
        int index1 = s5.indexOf('o',5);
        System.out.println("从索引5开始,o首次出现的位置是"+(index1+1));
        int index2 = s5.indexOf("world")+1;
        System.out.println("world首次出现的位置为:"+(index2));//按world的首字母的第一位置来寻找world的位置
        int index3 = s5.indexOf("java",10)+1;
        System.out.println("java在索引10首次出现的位置是"+index3);
        int index4 = s5.indexOf("java");
       if (index4==23){
           System.out.println("该语言或词汇在本语句中没有出现");
       } else {
           System.out.println("java在本文中的位置是"+(index4+1));
       }
        System.out.println(

        );
       //length是长度的引用
      String sk = "hello";
       String sk1 = "java programming";//空格也算一个单位长度
       String sk2  = "";
       String sk3 = null;
       //获取sk的长度
        int results = sk.length();
        System.out.println(results);
        int results1 = sk1.length();
        System.out.println(results1);
        int results2 = sk2.length();
        System.out.println(results2);
//null不可重复设置length(4)，会让系统抛出异常
        if (sk3!=null){
             int results3 = sk3.length();
            System.out.println("sk3的长度："+results3);
        }else {
            System.out.println("sk3是null,无法获取其长度");
        }
        //替换字符的引用,见javal2

    }
}
