package com.游戏;

import java.util.Scanner;

public class  paixv{
    static void main() {
        int a [] = new int[10];
        int max ;
        int maxsua = 1;
        int min ;
        int minsua = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        a[0] = scanner.nextInt();
        max = a[0];
        min = a[0];

        for (int k =1;k<a.length;k++) {
            System.out.println("请输入第" + (k + 1) + "个数字");
            a[k] = scanner.nextInt();
            if (a[k] >=max) {
                max = a[k];
                maxsua = k+1 ;

            }
            if (a[k]<=min) {
                min = a[k];
                minsua = k+1;
            }
        }

        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length-j-1; i++) {
                if (a[i] > a[i + 1]) {
                    int num = 0;
                    num = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = num;
                }
            }
        }
        System.out.print("从小到大排序为：");
        for (int i = 0; i < a.length; i++) {


            System.out.print(a[i]+"/");
        }
        System.out.println();
        System.out.print("最大值为"+max);
        System.out.println("最大值在第"+maxsua+"位");
        System.out.print("最小值为"+min);
        System.out.println("最小值在第"+minsua+"位");
    }
}