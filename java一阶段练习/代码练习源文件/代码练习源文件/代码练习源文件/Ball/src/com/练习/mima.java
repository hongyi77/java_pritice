package com.练习;

import java.util.Scanner;

public class mima {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "1293023362";
        int passout  = 123456987;


        for (int i = 0; i <3 ; i++) {
            System.out.println("请输入你的用户名");
            String usename = scanner.next();
            System.out.println("请输入你的密码");
            int usepassout = scanner.nextInt();
            if (usename.equals(name) && usepassout == passout) {
                System.out.println("恭喜你，成功注册");
                break;
            } else {
                if (i<2){
                    System.out.println("输入错误，一共还有"+(2-i)+"次机会");
                    continue;
                }else {
                    System.out.println("用户名和密码有错误，账户已锁定,请联系工作人员");
                    break;
                }
            }
        }
        scanner.close();
    }
}
