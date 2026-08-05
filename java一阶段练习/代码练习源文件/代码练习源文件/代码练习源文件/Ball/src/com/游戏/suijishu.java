package com.游戏;

import java.util.Random;
import java.util.Scanner;

public class suijishu {
    public static void main(String[] args) {
        System.out.println("欢迎来到猜数游戏，请开始你的体验");
        System.out.println("----------------");
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
       // int randomint= random.nextInt();
        //System.out.println(randomint);
        int randoma = random.nextInt(100);
        System.out.println(randoma);
        //System.out.println(randoma);
       // int randomb = 50+random.nextInt(51);
       // System.out.println(randomb);
       // double randomc = 12.8+random.nextDouble();
        //System.out.println(randomc);
        while(true){
            System.out.print("请输入一个数字(1-100)");
            int num = sc.nextInt();
             if (num > randoma){
                 System.out.println("不正确，太大了，请再试一试");
                 continue;
             }else if (num<randoma){
                 System.out.println("不正确，太小了，请再试一试");
                 continue;
             }else {
                 System.out.println("恭喜你，猜对了");
                 break;
             }

        }
        System.out.println("需要加大游戏难度吗(若是需要请输入1，退出游戏请输入2)");
        int num1 = sc.nextInt();
        if (num1==1){
            while(true){
                System.out.println("请输入一个数字(1-200)");
                int num = sc.nextInt();
                int random1 = random.nextInt(200);
                if (num>100&&num<0){
                    System.out.println("请输入有效数字");
                    continue;
                }
                if (num > random1){
                    System.out.println("不正确，太大了，请再试一试");
                    continue;
                }else if (num<random1){
                    System.out.println("不正确，太小了，请再试一试");
                    continue;
                }else {
                    System.out.println("恭喜你，猜对了");
                    break;
                }

            }

        } else if (num1==2) {
            System.out.println("成功退出");
        } else if (num1==99) {
            System.out.println("恭喜你解锁隐藏功能，祝你和你喜欢的人幸福99");
        }
        sc.close();
    }
}
