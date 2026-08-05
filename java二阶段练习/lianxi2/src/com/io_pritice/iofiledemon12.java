package com.io_pritice;

import java.io.FileWriter;
import java.io.IOException;
/*
构造方法 功能说明
FileWriter(File file) 创建字符输出流绑定文件，默认覆盖原文件内容
FileWriter(String pathname) 通过文件路径创建流，默认覆盖原文件内容
FileWriter(File file, boolean append) 带续写开关：append=true 末尾追加；append=false 覆盖
FileWriter(String pathname, boolean append) 通过路径创建流，支持续写开关

【续写开关--当一个文件的内容不想清空时，可以打开续写开关，继续写入内容】

方法 作用
void write(int c) 写入单个字符
void write(String str) 写入完整字符串（日常最常用）
void write(String str, int off, int len) 截取字符串片段写入，off起始索引，len截取长度
void write(char[] cbuf) 写入完整字符数组
void write(char[] cbuf, int off, int len) 截取字符数组片段写入

 */
public class iofiledemon12 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("D:\\githup仓库\\java二阶段练习\\lianxi2\\write.txt",true);
        //1.
       /* fw.write(54464);
        fw.close();*/

        //2.
        /*fw.write("车到山前必有路");
        fw.close();*/

        //3.
        /*fw.write("叫我爸爸",0,2);
        fw.close();*/

        //4.
        /*char [] chars = {'A','B','n','k','我'};
        fw.write(chars);
        fw.close();*/

        //5.
        char [] chars = {'A','B','n','k','我'};
        fw.write(chars,0,2);
         fw.close();
    }
}
