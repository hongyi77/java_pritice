package com.file_prictice;

import java.io.File;
import java.io.IOException;

public class filedemon1 {
    public static void main(String[] args) {
        // 新手的坑：new File("") 不会创建文件，它只是创建一个指向当前工作目录的对象
        // exists() 返回 true 是因为当前目录确实存在，不代表文件创建成功了
        File file = new File("test.txt");

        // 演示如何真正创建一个文件
        try {
            // createNewFile() 才会在磁盘上实际创建文件
            boolean created = file.createNewFile();
            System.out.println("是否成功创建: " + created);
            System.out.println("文件是否存在: " + file.exists());
            System.out.println("文件绝对路径: " + file.getAbsolutePath());
        } catch (IOException e) {
            // createNewFile 声明了 checked exception，必须处理
            e.printStackTrace();
        }

        // 补充：File 操作很多涉及 IO，会抛出 IOException
        // exists()/createNewFile()/delete() 等都要注意异常处理
    }
}
