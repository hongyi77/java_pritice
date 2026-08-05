package com.练习;

import java.util.Scanner;

public class zhongweishu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a[] = new double[5];
        double a1[] = new double[7];
        double[] zong = new double[a.length+a1.length];
        for (int i = 0;i< zong.length;i++){
            System.out.println("请输入第"+(i+1)+"个数字");
           zong[i]  = scanner.nextDouble();
        }


        /*for (int i =0; i<a.length;i++){
            if (i>=0) {
                zong[i] = a[i];
            }
        }
        for (int j =0; j<a1.length;j++){
            if (j>=0){
                zong[a.length+j] = a1[j];
            }*/

        for (int i =0;i< zong.length;i++){
            System.out.print(zong[i]+" ");
        }
        for (int i =0;i<zong.length;i++){
            for (int k = 0;k<zong.length-i-1;k++){
                if (zong[k]>zong[k+1]){
                    double num = zong[k];
                    zong[k] = zong[k+1];
                    zong[k+1]=num;

                }
            }
        }
        System.out.println();
        for (int k =0;k< zong.length;k++){
            System.out.print(zong[k]+" ");
        }
       double zhongwei = 0;
        int length = zong.length;
        if (length%2 ==1){
            zhongwei = zong[(length-1)/2];
        }else {
            zhongwei = (zong[(length)/2]+zong[(length-2)/2])/2.0;
        }
        System.out.println();
        System.out.println("这个数组的中位数为");
        System.out.print(zhongwei+" ");
    }
}
