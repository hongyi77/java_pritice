package com.off;

import java.util.Scanner;
//不重复的字符串
public class data_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = scanner.next();
        int leng = leng(s);
        System.out.println(leng);
    }
    private static int leng(String s){
        int maxline = 1;
        int a=1;
        char[]s1 = s.toCharArray();

        for (int i = 1; i <s1.length ; i++) {
            if (s1[i-1]==(s1[i])){
              a=1;
            }else {
                a++;
            }
            if(a>maxline){
                maxline =a;
            }
        }
        return maxline;
    }
}
