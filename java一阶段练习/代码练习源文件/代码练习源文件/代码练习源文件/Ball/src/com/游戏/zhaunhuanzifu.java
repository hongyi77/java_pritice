package com.游戏;
//洗牌法的逻辑可以参考冒泡排序法
import java.util.Random;
import java.util.Scanner;

public class zhaunhuanzifu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入提个字符串，我帮你打乱它的顺序");
        String arr = scanner.next();
        String result = geta(arr);
        System.out.println(result);
    }
    //fisher洗牌法
    public static String geta(String a){
        Random random = new Random();
        char chars[]=a.toCharArray();
        for (int i = chars.length-1; i > 0; i--) {
            int j  = random.nextInt(i+1);
            char temp = chars[i];
            chars[i]=chars[j];
            chars[j] = temp;

        }
        return new String(chars);
    }
}
