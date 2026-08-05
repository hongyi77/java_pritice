package com.file_prictice;

import java.io.File;
import java.util.Scanner;
//File的概述和构造方法
//路径分为两种，分为相对路径和绝对路径

/*
File(String name) 根据文件路径创建文件对象
Filr(String parent String child) 根据父路径名字符串和子路径名字符串创建文件对象
Filr(String parent String child) 根据父路径名字符对应文件对象和子路径名字符对应文件对象

/--这个叫做反斜线       \--这个叫做正斜线
*/

public class filedemon2 {
    public static void main(String[] args) {
        //第一种情况
      String a = "D:\\创造";
        File file = new File(a);
        System.out.println(file);
        //第二种情况
        String parent = "D:\\创造";
        String child = "a.txt";
        File file1 = new File(parent,child);
        System.out.println(file1);
        File file2 = new File(parent+"//"+child);
        System.out.println(file2);
        //第三种情况
        File file3 = new File("D:\\创造");
        String child1 = "a.txt";
        File f4 = new File(file3,child1);
        System.out.println(f4);

    }
}
