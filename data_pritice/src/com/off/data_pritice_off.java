package com.off;

import java.util.Scanner;
//两数相加
public class data_pritice_off {
    public static void main(String[] args) {
        requst();
    }
    //获得数组和目标值
    private static void requst(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int k = getIntInput(scanner);
        int[] a= new int[k];
        for (int i = 0; i <a.length ; i++) {
            System.out.println("请依次输入数组的数字");
            System.out.println("第"+(i+1)+"个");
            a[i] = getIntInput(scanner);
        }
        System.out.println("请输入目标值");
        int target = getIntInput(scanner);
        int[] result = result(a, target);
        for (int b:result){
            System.out.print(b+" ");
        }
    }
    //算出加减法的逻辑
    public static  int []result (int[]a,int target){
        int i;
        int j;
        for ( i = 0; i<a.length ; i++) {
            for ( j = 0; j <i ; j++) {
                if (target == a[i]+a[j]){
                    System.out.println((i+1)+"和"+(j+1));
                    System.out.println(a[i]+"和"+a[j]);
                    System.out.println("----");
                }else {
                    continue;
                }
            }
        }
      return a;
    }
    private static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("输入无效，请输入数字: ");
            sc.next();
        }
        return sc.nextInt();
    }
//123
//123
}
