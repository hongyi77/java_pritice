package com.io_pritice;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

//前九个练习都是字节流，从本章开始，开始是实行字符流--分为 Reader和Writer
/*
public int read() 读到数据，读到末尾返回-1
public int read(char[] char )  读取多个数据，都到末尾返回一
 */
public class iofiledemon10 {
    public static void main(String[] args) throws IOException {
       FileReader fil = new FileReader("D:\\githup仓库\\java二阶段练习\\lianxi2\\q.txt");
        int ch;
        while ((ch= fil.read())!=-1){
            System.out.print((char) ch);
        }
        System.out.println("-----------------");
/*  以下注释的方法，当打印文字时会出现乱码，但图片读取拷贝图片或视频只能用这个
        FileInputStream fis = new FileInputStream("D:\\githup仓库\\java二阶段练习\\lianxi2\\q.txt");
        int len;
        while ((len=fis.read())!=-1){
            System.out.print((char) len);
        }
        fis.close();*/

        fil.close();

    }
    /*
    对比项	FileReader	FileInputStream
流分类	字符流 Reader	字节流 InputStream
读取单位	单个字符	单个字节
中文支持	原生支持，无乱码	直接打印乱码
文件适用	仅限文本文件	所有文件（文本/图片/视频）
典型用途	读取、打印文字内容	文件复制、二进制资源处理
     */

}
