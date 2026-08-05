package com.练习;

import java.util.Scanner;

public class mathl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jifoot = 0;int tufoot =0;
        int ji = 0;int tu =0;
        System.out.println("请输入鸡和兔总共的脚数");
        int totalfeet = scanner.nextInt();
        System.out.println("请输入鸡和兔总共的头数：");
        int totalhead = scanner.nextInt();
     tu = totalhead-ji;
     if (totalfeet>0&&totalhead>0){
         ji = (totalhead*4-totalfeet)/2;
         tu = totalhead-ji;
         System.out.println("正在为你计算中");
         System.out.println("鸡的数量为："+ji);
         System.out.println("兔的数量为："+tu);
     }else {
         System.out.println("你输入的头数和脚数不匹配");
     }
     if (ji>0&&tu>0&&jifoot+tufoot==totalfeet&&ji+tu==totalhead){
         System.out.println("鸡的数量为："+ji);
         System.out.println("兔的数量为："+tu);
     }
        jifoot = ji*2;
        tufoot = tu*4;
        System.out.println("鸡的脚数为："+jifoot);
        System.out.println("兔的脚数为："+tufoot);
          /*  System.out.println("请分别输入鸡和兔的头数");
              System.out.print("鸡：");
            int ji = scanner.nextInt();
              System.out.print("兔:");
            int tu = scanner.nextInt();
        System.out.println("请再分别输入鸡和兔的脚的数量");
        System.out.print("鸡的脚数：");
        int jifoot = scanner.nextInt();
        System.out.print("兔的脚数：");
        int tufoot = scanner.nextInt();
        System.out.println();*/


    }
}