package com.off;

import java.util.Arrays;
import java.util.Scanner;

//中位数
public class data_minindex {
    public static void main(String[] args) {
        double[] c = c();
        double zhong = zhong(c);
        System.out.println(zhong);


    }

    //中位数创建逻辑
    private static double zhong(double []c){
        double zhongwei = 0;
        //偶数计算逻辑
        if (c.length%2==0){
         zhongwei= (c[c.length/2-1]+c[c.length/2])/2.0;
        }
        //奇数计算逻辑
        if (c.length%2==1){
            zhongwei=c[(c.length+1)/2-1];
        }
        return zhongwei;
    }


    //数组创建逻辑
    private static double []c(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int k = getIntInput(scanner);
        double[] a= new double[k];
        for (int i = 0; i <a.length ; i++) {
            System.out.println("请依次输入数组的数字");
            System.out.println("第"+(i+1)+"个");
            a[i] = getDoubleInput(scanner);
        }
        System.out.println("请再次输入数组的长度");
        int k1 = getIntInput(scanner);
        double[] a1= new double[k1];
        for (int i = 0; i <a1.length ; i++) {
            System.out.println("请依次输入数组的数字");
            System.out.println("第"+(i+1)+"个");
            a1[i] = getDoubleInput(scanner);
        }
        double[] result = new double[a1.length+a.length];
        System.arraycopy(a,0,result,0,a.length);
        System.arraycopy(a1,0,result,a.length,a1.length);
        Arrays.sort(result);
        return result;

    }
    private static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("输入无效，请输入数字: ");
            sc.next();
        }
        return sc.nextInt();
    }
    private static double getDoubleInput(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("输入无效，请输入数字: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
