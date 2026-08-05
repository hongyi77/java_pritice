package com.allpritice.io;

import java.io.*;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class priticestressfulio {
    //该项目是把一个文件夹中的所有文件和文件夹拷贝到拷贝目的地
    public static void main(String[] args) throws IOException {
        //代码拷贝源文件
        File src = new File("D:\\IdeaProjects\\代码练习源文件");
        //拷贝目的地
        File goal = new File("D:\\文件实验地",src.getName() + ".zip");
        //创建压缩输出流
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(goal));
        //调用方法
        Fileout(src,zos, src.getName());
        //关闭资源
        zos.close();

    }
    public static void Fileout(File src,ZipOutputStream zos,String name) throws IOException {
        //获取目录文件
        File[] files = src.listFiles();
        for (File file:files){
            //该文件的文件夹是系统自动产生的
            //if是处理文件；else是处理文件夹
            if (file.isFile()){
               ZipEntry zipEntry = new ZipEntry(name+"\\"+file.getName());
               zos.putNextEntry(zipEntry);//开辟一个文件的入口，创建一个文件本身
               FileInputStream fis = new FileInputStream(file);
               int b;
               while ((b= fis.read())!=-1){
                 zos.write(b);//写入每一个文件的内容
               }
               fis.close();
               zos.closeEntry();
            }else {
                //递归 注意：这里不是创建一个文件夹
                Fileout(file, zos, name+"\\"+file.getName());
            }
        }

    }
}
