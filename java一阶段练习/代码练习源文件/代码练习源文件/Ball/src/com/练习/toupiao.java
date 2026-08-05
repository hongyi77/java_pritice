package com.练习;

import java.util.Random;

public class toupiao {
    public static void main(String[] args) {
        //初始化6个候选人的名额
        int a []  = new int[6];
       //模拟1000次投票
        Random random = new Random();
        for (int j = 0; j <1000 ; j++) {
            //生成0-5的随机数，这个东西是左开右闭
            int u = random.nextInt(6);
            a[u]++;//依次对对应的索引数票数加1，循环一千次
        }
        for (int i = 1; i <a.length ; i++) {
            System.out.println(i+"号候选人得票数为"+a[i]+" "+"得票率为"+a[i]*1.0/1000*100+"%");
        }
        int max=a[1];int minsua = 0;
        for (int i = 2; i <a.length ; i++) {
            if (a[i]>max){
                max = a[i];
                minsua = i;
            }

        }
        for (int i = 0; i <a.length ; i++) {
    if (a[i]==max&&minsua!=0) {
        System.out.println("得票数最多的是" + minsua + "号候选人" + " " + "一共" + max + "票");
        break;
    } else if (minsua==0) {
        System.out.println("得票数最多的是" + 1 + "号候选人" + " " + "一共" + max + "票");
        break;
    }

        }
        System.out.println("部分人没有投票"+"弃票率为"+a[0]*1.0/1000*100+"%");
    }
}
