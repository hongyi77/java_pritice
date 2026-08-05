package com.file_prictice;

import java.io.File;
import java.util.Arrays;

/*
public File[] listFiles()	获取当前该路径下所有内容
public File[] listFiles(FileFilter filter)	利用文件名过滤器获取当前该路径下所有内容
public File[] listFiles(FilenameFilter filter)	利用文件名过滤器获取当前该路径下所有内容
 */
//public File[] listFile()   获取当前路径下的所有内容
public class filedemon6 {
    public static void main(String[] args) {
        File file = new File("D:\\文件实验地\\sss\\ffd");//创建一个File对象
        //调用listFile()方法，哪怕是隐藏的文件夹也可以获取
        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
