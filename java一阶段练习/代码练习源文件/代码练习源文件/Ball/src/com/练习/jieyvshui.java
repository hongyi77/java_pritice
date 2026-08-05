package com.练习;

public class jieyvshui {
    public static void main(String[] args) {
        int height []= {0,1,0,2,1,0,1,3,2,1,2,1};
        int leftteam[]  = new int[height.length];
        int team = height[0];
        for (int i = 0; i < height.length ; i++) {
            if (team>height[i]){
                leftteam[i] = team;
            }else {
                leftteam[i] = height[i];
                team = height[i];
            }
        }
        System.out.println("从左遍历数组为：");
        for (int i = 0; i < height.length ; i++) {

            System.out.print(leftteam[i]+ " ");
        }
        System.out.println();
        team = 0;
        int[] rightteam = new int[height.length];
        for (int i = height.length-1; i>=0 ; i--) {
            if (team>height[i]){
                rightteam[i] = team;
            }else {
                rightteam[i] = height[i];
                team = height[i];
            }
        }
        System.out.println("从右遍历数组为:");
        for (int i = 0; i < height.length; i++) {
            System.out.print(rightteam[i]+" ");
        }
        int jieyv[] = new int[height.length];
        for (int k = 0;k<height.length;k++){
            if (leftteam[k]>rightteam[k]){
                leftteam[k] = rightteam[k];
                jieyv[k] = leftteam[k];
            }else {
                rightteam[k] = leftteam[k];
                jieyv[k] = rightteam[k];
            }
        }
        System.out.println("");
        System.out.println("这个数组接雨水的数组为：");
        for (int i = 0; i <height.length ; i++) {
            System.out.print(jieyv[i]+" ");
        }
        System.out.println();
        int sum = 0;
        for (int i = 0; i <height.length ; i++) {
           sum = sum+jieyv[i];
        }
        for (int i = 0; i <height.length ; i++) {
            sum =sum-height[i];
        }
        System.out.print("所以说这个数组的凹槽一共能接"+sum+"滴雨水");

    }
}
