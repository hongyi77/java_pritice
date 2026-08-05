package com.file_prictice;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class filedemon_lianxi {
    public static void main(String[] args) {
      //练习一  //创造一个后缀名为.txt的文件，并看看该文件是否存在
       /* File file = new File("D:\\文件实验地\\ddd\\a.txt");
        try {
            boolean newFile = file.createNewFile();
            System.out.println("创建状态："+newFile);
            String name = file.getName();
            System.out.println(name);
            boolean exists = file.exists();
            System.out.println("该文件存在的状态"+exists);
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        */
     //练习二   //在某一个文件夹里查询某一个特定的文件()  我这里是设定一个存着al创作视频的文件夹，后缀名为.mpka4
       /* File file = new File("D:\\视频");
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                File file1 = new File(file,s);
                return file1.isFile()&&s.endsWith(".mp4");
            }
        });
        System.out.println(Arrays.toString(files));*/
        //练习三 //在某一个盘中找到后缀名为mp4的所有文件
       /* File file  =  new File("D:\\");
        find(file);*/
    }
   /* public static void find(File src){
        File[] files = src.listFiles();
        /*if (files ==null){
                System.out.println(src);
        }//D:\$RECYCLE.BIN\S-1-5-21-3869087590-91093326-3258558203-500该文件夹没有权限
        if (files!=null) {
            for (File file:files) {
                //如果是文件，就可以执行题目的业务逻辑
                if (file.isFile()){
                    String name = file.getName();
                    if (name.endsWith(".mp4")){
                        System.out.println(file);
                    }
                }else {
                    find(file);
                }
            }
        }
    }*///实现练习三的静态方法
}
