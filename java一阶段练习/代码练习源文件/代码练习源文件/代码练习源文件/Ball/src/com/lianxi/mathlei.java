package com.lianxi;

import java.util.Scanner;

public class mathlei {
    public static void main(String[] args) {
        int a [] = new int[10];
        int b [] = new int[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <a.length ; i++) {
            System.out.println("请输入第"+(i+1)+"数字");
            a[i] = scanner.nextInt();
        }
        for (int i = 0;i>a.length;i++){
            System.out.println("请输入第"+(i+1)+"数字");
            b[i] = scanner.nextInt();
        }
        int maxa = getmax(a);
        int maxb = getmin(b);
        int finishmax = Math.max(maxa,maxb);
        int mina = getmin(a);
        int minb = getmin(b);
        int finishmin = Math.min(mina,minb);
        System.out.println("两个数组最大值为"+finishmax);
        System.out.println("两个数组最小值为为"+finishmin);


    }
    public static int getmax(int arr[]){
        int max = arr[0];
        for (int num :arr) {
            max = Math.max(num,max);
        }
        return max;
    }
    public static int getmin(int arr[]){
        int min = arr[0];
        for (int num:arr){
            min = Math.min(num,min);
        }
        return min;
    }
}
