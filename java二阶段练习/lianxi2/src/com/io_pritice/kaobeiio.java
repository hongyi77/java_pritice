package com.io_pritice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
//文件拷贝，  文件加io的综合练习
/*
三个问题
1. new FileInputStream(goal) → 应改为 new FileInputStream(file)，否则永远读同一个文件
  2. try-with-resources 引用外部变量 → 改为括号内直接初始化更稳妥
  3. 递归传 goal → 应传 file，否则无限递归同一目录
 */
public class kaobeiio {
    public static void main(String[] args) throws IOException {
        File goal = new File("D:\\javaproject");
        File put = new File("D:\\拷贝\\拷贝1");
        copy(goal, put);
    }

    public static void copy(File goal, File put) throws IOException {
        put.mkdirs();
        File[] files = goal.listFiles();
        if (files == null) {
            System.out.println("该文件没有任何可拷贝对象");
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                File dest = new File(put, file.getName());
                if (dest.exists()){
                    System.out.println(dest.getName()+"已经存在");
                    return;
                }
                try (FileInputStream fis = new FileInputStream(file);
                     FileOutputStream fos = new FileOutputStream(dest)) {
                    int len;
                    byte[] bytes = new byte[1024];
                    while ((len = fis.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                        System.out.println("已为你拷贝了"+dest.getName()+" 文件");
                    }
                }
            } else {
                copy(file, new File(put, file.getName()));
            }
        }
    }
}
