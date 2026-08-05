package com.file_prictice;

import java.io.File;

//File中常见的方法
public class filedemon3 {
    public static void main(String[] args) {
        //对一个文件夹进行判断
        File file =  new File("D:\\文件实验地\\fff");
        boolean file1 = file.isFile();
        boolean directory = file.isDirectory();
        System.out.println(file1);   //false
        System.out.println(directory);  //true

        //对一个文件进行判断
        File file2 = new File("D:\\文件实验地\\rrr.rtf");
        boolean file3 = file2.isFile();
        boolean exists = file2.exists();
        boolean directory1 = file2.isDirectory();
        System.out.println(file3);  //true
        System.out.println(exists);  //true
        System.out.println(directory1);   //false

        //对一个不存在的文件夹进行判断
        File file4 = new File("D:\\大时代");
        boolean file5 = file4.isFile();
        boolean exists1 = file4.exists();
        boolean directory2 = file4.isDirectory();
        System.out.println(file5+" "+exists1+" "+directory2);//三个false



    }
}
