package com.file_prictice;

import java.io.File;

public class filedemon_lianxi00  {
    public static void main(String[] args) throws NullPointerException{
        /*练习一 删除一个多级文件夹
        如果要删除一个有内容的文件夹
        1.先删除一个文件夹里面的所有内容
        2.再剔除自己
/*
此方法经试验之后，只能删除一种文件夹里的多级内容，但不能删除进入一种文件夹之后的所有文件夹
若是想要删除，一级一级删除
         */
       /* File file = new File("D:\\文件实验地\\sss");//不要改这里
        delete1(file);*/
    }
    //实现删除文件的静态方法
    public static  void delete1(File src){
        File[] files = src.listFiles();

        if (files!=null) {
            for (File file:files){
              if (file.isDirectory()){
                  System.out.println("成功删除"+file.getName());
                  file.delete();
                  delete1(file);
                  if (!file.exists()){
                      break;
                  }
              }else {
                  delete1(file);
              }
            }
        }
        //删除自己
        src.delete();
        }

}
