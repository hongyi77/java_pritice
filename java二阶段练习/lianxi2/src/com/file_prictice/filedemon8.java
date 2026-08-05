package com.file_prictice;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

/*
public File[] listFiles(FileFilter filter)	利用文件名过滤器获取当前该路径下所有内容
public File[] listFiles(FilenameFilter filter)	利用文件名过滤器获取当前该路径下所有内容
 */
public class filedemon8 {
    public static void main(String[] args) {
        File file = new File("D:\\文件实验地");
        File[] files = file.listFiles(new FileFilter() {//该正则表达式，它会拿到完整的文件路径
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".rtf")||file.getName().endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(files));
        File[] files1 = file.listFiles(new FilenameFilter() {//该正则表达式，它会拿到完整的文件名字
            @Override
            public boolean accept(File file, String s) {
               File src = new File(file,s);
                System.out.println(src);
                return src.isFile()&&s.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(files1));
    }
}
