package com.STring;

import java.util.Scanner;

public class STringBulter {
    //可用于reverse，length，tostring，append
    public static void main(String[] args) {
        //对称数需要满足2的倍数的位数
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个字符串");
            String c = sc.next();
            int a = 0;
            int b = 1;
            int a1 = c.length()-1;
            int b1 = c.length();
            while (c.length() % 2 == 1) {
                if (c.length()==1){
                    System.out.println(c+"该数只有一位数，不是对称数");
                    break;
                }
                if (c.substring(a, b).equals(c.substring(a1 , b1))) {
                    a++;
                    b++;
                    a1--;
                    b1--;
                }else {
                    System.out.println("该数不是对称数");
                    break;
                }
                if (b == ((c.length() - 1) / 2 )+1 && (a1 == (c.length() - 1) / 2 )) {
                    System.out.println("该数为单倍对称数");
                    break;
                }
            }
            while (c.length() % 2 == 0) {
                if (c.length()==2&&b==a1&&c.substring(0,1).equals(c.substring(1,2))){
                    System.out.println(c + "是一个双倍对称数");
                    break;
                }
                else if (c.substring(a, b).equals(c.substring(a1, b1))) {
                    a++;
                    b++;
                    a1--;
                    b1--;
                }else {
                    System.out.println("该数不是对称数");
                    break;
                }

                    if (b == (c.length() / 2) && a1 == (c.length() / 2) && c.substring((c.length() / 2) - 1, (c.length() / 2)).equals(c.substring((c.length() / 2), (c.length() / 2) + 1))) {
                            System.out.println(c + "是一个双倍对称数");
                        break;
                    }

            }



        }
    }
}