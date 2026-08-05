package com.练习;

import java.util.Random;

public class hongbao {
    public static void main(String[] args) {
        int hong = 20000;
        int n = 5;
        Random r = new Random();
        //int sheng = hong;
        for (int i = 1; i <=n-1 ; i++) {
            int arr1 = r.nextInt(hong-(n-i))+1;
            hong = hong - arr1;
            System.out.println("第"+i+"个人抢到了"+arr1+"元");
        }
        System.out.println("第"+n+"个人抢到了"+hong+"元");
    }
}
