package com.STring;

import java.util.Scanner;

public class riqi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money;
        while (true) {
            System.out.println("请输入金额：");
            money = scanner.nextInt();
            if (money > 0 && money < 50000000) {
                break;
            } else {
                System.out.println("输出金额无效");
            }
        }
         StringBuffer str = new StringBuffer();
           while (true){
               int ge =  money%10;
               String ger = getmoney(ge);
         /*StringBuffer方法不能运用到while循环中,否则会报错。
               且reverse方法也同样如此，采用方法每次记录无效*/
               str.append(ger);
               money = money/10;
               if (money == 0){
                   break;
               }
           }

        str.reverse();
        System.out.print(str.toString());
    }
    public static String getmoney(int num){
        String [] a =  {"零","壹","贰","叁","肆","伍","鎏","柒","扒","玖"};
        return a[num];
    }
}
