package com.lianxi;

public class Java2 {
    public static void main(String[] args) {
       /* System.out.println("替换");
        String s2 = new String("hello python");
        if (s2.contains("python")){
            s2 = s2.replace("python","java");
            System.out.println(s2);
        }else{
            System.out.println("没有找到你想替换的字符串");
        }*/
        //insert类
        StringBuffer s1 = new StringBuffer("hello,java");
        System.out.println(s1);
        s1.delete(6,(s1.length()-1));
        System.out.println(s1);


    }
}
