package com.off;
//寻找回文数
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class data_hui {
    public static void main(String[] args) {
        Set<String>set =new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String next = scanner.next();
        int a1=0; int a=0;
        for (int i = 0; i <next.length() ; i++) {
            //当回文数为奇数时
             a1 += a(next, set, i, i);
            //当回文数为偶数时
             a += a(next, set, i, i + 1);
        }
        System.out.println("回文数都有"+set+",共有"+(a+a1)+"个回文数");

    }
    //找到字符串中真正的回文数
    public static int a(String next,Set<String> set,int left,int right){
           int count = 0;
       /* if (next.length()%2==0){
            left=next.length()/2;
            right = left+1;
        }else if (next.length()%2==1){
            left = right = next.length()/2;
        }*/     //该代码是错误的代码，只是从中位数索引向两边扩，并不能找到真正的回文数
        while (left>=0&&right<next.length()&&next.charAt(left)==next.charAt(right)){
               if (left!=right) {
                   set.add(next.substring(left, right + 1));
                   count++;
               }
                left--;
                right++;

        }
     return count;
    }
}
