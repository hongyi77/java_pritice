package com.练习;

import java.util.Random;
import java.util.Scanner;

public class daletou {
    public static void main(String[] args) {
        int[] a = new int[6];
        int[] cai = new int[a.length];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数字");
            cai[i] = scanner.nextInt();
        }
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            cai[i] = random.nextInt(10);
        }
        int ge = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == cai[i]) {
                ge++;


            }
        }
            System.out.println("一共有" + ge + "个一样的");
        if (ge==cai.length){
            System.out.println("恭喜你中奖了");
        }else{
            System.out.println("谢谢惠顾");
        }
    }
}
