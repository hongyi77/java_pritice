package com.练习;

import java.util.Random;
import java.util.Scanner;

public class dale {
    public static void main(String[] args) {
        // 1. 生成彩票号码
        int[] lottery = createLotteryNumber();
        System.out.println("本期大乐透开奖号码：");
        System.out.print("前区：");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%02d ",lottery[i]);//百分号的值被lottery替换了
        }
        System.out.print(" | 后区：");
        for (int i = 5; i < 7; i++) {
            System.out.printf("%02d ",lottery[i]);
        }
        System.out.println();

        // 2. 用户输入彩票号码
        int[] user = inputUserNumber();

        // 3. 判断中奖情况
        judge(lottery, user);
    }

    // 生成彩票号码：前区5个1-35不重复，后区2个1-12不重复
    public static int[] createLotteryNumber() {
        int[] arr = new int[7];
        Random r = new Random();

        // 生成前区5个号码
        for (int i = 0; i < 5; ) {
            int number = r.nextInt(35) + 1;
            if (!contains(number, arr)) {
                arr[i] = number;
                i++;
            }
        }

        // 生成后区2个号码
        for (int i = 5; i < 7; ) {
            int number = r.nextInt(12) + 1;
            if (!contains(number, arr)) {
                arr[i] = number;
                i++;
            }
        }
        return arr;
    }

    // 判断数组中是否包含指定数字
    public static boolean contains(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }

    // 用户输入彩票号码
    public static int[] inputUserNumber() {
        int[] user = new int[7];
        Scanner sc = new Scanner(System.in);

        // 输入前区号码
        System.out.println("请输入您选择的前区5个号码（1-35，不重复）：");
        for (int i = 0; i < 5; ) {
            int num = sc.nextInt();
            if (num >= 1 && num <= 35 && !contains(num, user)) {
                user[i] = num;
                i++;
            } else {
                System.out.println("输入无效，请输入1-35之间且未重复的号码！");
            }
        }

        // 输入后区号码
        System.out.println("请输入您选择的后区2个号码（1-12，不重复）：");
        for (int i = 5; i < 7; ) {
            int num = sc.nextInt();
            if (num >= 1 && num <= 12 && !contains(num, user)) {
                user[i] = num;
                i++;
            } else {
                System.out.println("输入无效，请输入1-12之间且未重复的号码！");
            }
        }
        return user;
    }

    // 判断中奖情况
    public static void judge(int[] lottery, int[] user) {
        int frontHit = 0;
        int backHit = 0;

        // 统计前区命中数
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (lottery[i] == user[j]) {
                    frontHit++;
                    break;
                }
            }
        }

        // 统计后区命中数
        for (int i = 5; i < 7; i++) {
            for (int j = 5; j < 7; j++) {
                if (lottery[i] == user[j]) {
                    backHit++;
                    break;
                }
            }
        }

        // 输出结果
        System.out.println("您的号码命中：前区" + frontHit + "个，后区" + backHit + "个");
        if (frontHit == 5 && backHit == 2) {
            System.out.println("恭喜您，中了一等奖！");
        } else if (frontHit == 5 && backHit == 1) {
            System.out.println("恭喜您，中了二等奖！");
        } else if (frontHit == 5 && backHit == 0) {
            System.out.println("恭喜您，中了三等奖！");
        } else if (frontHit == 4 && backHit == 2) {
            System.out.println("恭喜您，中了四等奖！");
        } else if ((frontHit == 4 && backHit == 1) || (frontHit == 3 && backHit == 2)) {
            System.out.println("恭喜您，中了五等奖！");
        } else if ((frontHit == 4 && backHit == 0) || (frontHit == 3 && backHit == 1) || (frontHit == 2 && backHit == 2)) {
            System.out.println("恭喜您，中了六等奖！");
        } else {
            System.out.println("很遗憾，未中奖，下次加油！");
        }
    }
}