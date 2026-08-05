package com.file_prictice;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/*
方法名称	说明
public static File[] listRoots()	列出可用的文件系统根
public String[] list()	获取当前该路径下所有内容
public String[] list(FilenameFilter filter)	利用文件名过滤器获取当前该路径下所有内容
public File[] listFiles()	获取当前该路径下所有内容
public File[] listFiles(FileFilter filter)	利用文件名过滤器获取当前该路径下所有内容
public File[] listFiles(FilenameFilter filter)	利用文件名过滤器获取当前该路径下所有内容

listFiles重点掌握，其他的做一个了解即可
 */
public class filedemon7 {
    public static void main(String[] args) {
        //listRoots()
       /* File[] files = File.listRoots();
        System.out.println(Arrays.toString(files));//输出结果为[C:\, D:\]*/
        //list()
       /* File file = new File("D:\\文件实验地");
        String []arr2 = file.list();
        for (String s:arr2
             ) {
            System.out.println(s);
        }*/
       File file = new File("D:\\文件实验地");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
               /* System.out.println("************");
                System.out.println(file);
                System.out.println(s);
                System.out.println("************");*/
                File src = new File(file,s);
                return src.getName().endsWith(".txt")&&src.isFile();
            }
        });
        System.out.println(Arrays.toString(list));

    }

}
