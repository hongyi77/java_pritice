package com.练习;

import java.util.Scanner;

public class yichu {
    public static void main(String[] args) {
        System.out.println("当你输入了6，最终结果不会显示6");
        System.out.println("-------------------******-------------------");
        System.out.println("去除你想去除的数字后得到的数组为：");
        System.out.println("---------------------------");
        System.out.println("同时这些数字我会帮你排序");
        int val = 6;
        int fast = 0;
        int slow = 0;
        Scanner scanner = new Scanner(System.in);
        int a[] = new int[5];
        for (int i = 0; i < a.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数字");
            a[i] = scanner.nextInt();

        }
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - j - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int num = 0;
                    num = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = num;
                }
            }
        }
            while (fast < a.length) {
                if (a[fast] != val) {
                    a[slow] = a[fast];
                    slow++;
                }
                fast++;
            }

            for (int i = 0; i < slow; i++) {

                System.out.print(a[i] + " ");
            }
        System.out.println();
        System.out.println("同时我将这些数字排序了，也就是说这是排序后的数字");
    }
}