package com.off;

import java.util.Scanner;

public class data_pritice1 {
    //两数相加（进阶版），数组决定个十
    public static void main(String[] args) {
        requst();

    }

    private static  int[] jack(int[]a,int[]a1){
        int[]b;  boolean isout = true;
        if (a.length>a1.length){
            b=new int[a.length];
        }else {
            b=new int[a1.length];
            isout = false;
        }
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0;j<a1.length;j++){
              if (i==j){
                  if (isout) {
                      b[i] = a[i] + a1[j];
                  }else {
                      b[j] = a[i]+ a1[j];
                  }
              }else {
                  if (isout){
                      if (i-j== a1.length){
                          b[i] = a[i];
                      }
                  }else {
                      if (j-i==a.length){
                          b[j] =a1[j];
                      }
                  }
              }
            }
        }
        return b;
    }
    private static void requst(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int k = getSingleDigitInput(scanner);
        int[] a= new int[k];
        for (int i = 0; i <a.length ; i++) {
            System.out.println("请依次输入数组的数字（0-9）");
            System.out.println("第"+(i+1)+"个");
            a[i] = getSingleDigitInput(scanner);
        }
        System.out.println("请再次输入数组的长度");
        int k1 = getIntInput(scanner);
        int[] a1= new int[k1];
        for (int i = 0; i <a1.length ; i++) {
            System.out.println("请依次输入数组的数字（0-9）");
            System.out.println("第"+(i+1)+"个");
            a1[i] = getSingleDigitInput(scanner);
        }
        int[] jack = jack(a, a1);
        // 处理进位（agnes 写的）
        for (int i = 0; i < jack.length; i++) {
            if (jack[i] >= 10) {
                jack[i] = jack[i] % 10;
                if (i + 1 < jack.length) {
                    jack[i + 1]++;
                } else {
                    // 最高位进位，需要扩容
                    int[] newArr = new int[jack.length + 1];
                    System.arraycopy(jack, 0, newArr, 0, jack.length);//拷贝数组
                    /*
                    jack → 源数组（原来的结果数组）
                    0 → 从第 0  位开始
                    newArr → 目标数组（新创建的、多一位的数组）
                    0 → 从第 0 位开始写入
                    jack.length → 拷贝 jack 的全部长度
                     */
                    newArr[jack.length] = 1;
                    jack = newArr;
                }
            }
        }
        int target = 0;
        for (int j = jack.length - 1; j >= 0; j--) {
            target = target * 10 + jack[j];
        }
        System.out.println(target);

    }
    // 输入单个数字（0-9）（agnes 加的）
    private static int getSingleDigitInput(Scanner sc) {
        while (true) {
            System.out.print("请输入0-9的数字: ");
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                if (num >= 0 && num <= 9) {
                    return num;
                }
                System.out.println("输入无效，请输入0-9的数字");
            } else {
                System.out.println("输入无效，请输入数字");
                sc.next();
            }
        }
    }

    // 输入数组长度（agnes 加的），限制在合理范围
    private static int getIntInput(Scanner sc) {
        while (true) {
            System.out.print("请输入数字（1-100）: ");

            if (sc.hasNextLong()) {
                long num = sc.nextLong();
                if (num >= 1 && num <= 100) {
                    return (int) num;
                }
                System.out.println("输入无效，请输入1到100之间的数字");
            } else {
                System.out.println("输入无效，请输入数字");
                sc.next();
            }
        }
    }
}
