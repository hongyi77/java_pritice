package com.STring;

import java.util.Scanner;
//整形转换阿拉伯数字，它的大小不能超过21亿
//若想要超过21亿需要进行转型
//或者使用String字符串类型，StringBuffer类型等也可以
//或者用一个boolean类型的成员方法和一个int整型的成员方法
//共三种方法，以下代码只用了一种int整形方法，不能对21亿以上的数字进行输出
public class pingjie {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个字符串(只能是数字，且位数小于等于九)");
            int num = scanner.nextInt();
            if (num>999999999){
                System.out.println("格式不对请重新输入");
                continue;
            }
            String result = nummer(num);
            System.out.println(result);

        }
    }
    public static  String nummer(int num) {

       /* if (num == 0) {
            System.out.println("长度为零的字符串");
        }*/
        if (num<0){
            System.out.println("当前不支持负数转换，请重新输入");
        }
        if (num>999999999){
            System.out.println("但前格式输入错误，请重新输入");
            return "";
        }
        String shu[]={"长度为零的字符串","Ⅰ","Ⅱ","Ⅲ","Ⅳ","Ⅴ","Ⅵ","Ⅶ","Ⅷ","Ⅸ"};
        StringBuilder resu = new StringBuilder();
        String alabo ="";
        while (true){

                int nim = num % 10;
                num =num/10;
                 alabo = shu[nim]+alabo;

                //resu.insert(0,shu[nim]);
                if (num==0) {
                    System.out.println(alabo);
                    break;
                }

            }


        return "";
    }
}