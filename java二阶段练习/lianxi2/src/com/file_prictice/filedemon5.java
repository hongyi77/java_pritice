package com.file_prictice;

import java.io.File;
import java.io.IOException;

/*
方法名称	说明
public boolean createNewFile()	创建一个新的空的文件
public boolean mkdir()	创建单级文件夹
public boolean mkdirs()	创建多级文件夹
public boolean delete()	删除文件、空文件夹
 */
public class filedemon5 {
    public static void main(String[] args) {
        //1.ceeateNewFile()
        File file = new File("D:\\文件实验地\\t.txt");
        try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);//创建一个名为t.txt的文件
            boolean exists = file.exists();
            System.out.println(exists);//确定这个文件是否存在
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);//获取该文件的绝对路径
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file1 = new File("D:\\文件实验地\\sss\\ffd\\aa\\bb");
        boolean mkdir = file1.mkdirs();
        System.out.println(mkdir);//生成一个单级文件夹


    }
}
