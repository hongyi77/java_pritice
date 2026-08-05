package com.io_pritice;

import java.io.FileOutputStream;
import java.io.IOException;

public class iofiledemon1 {
    /*
    // 1. 一次写入单个字节
void write(int b) throws IOException

// 2. 一次性写入整个字节数组全部内容
void write(byte[] b) throws IOException

// 3. 写入字节数组的一部分：从off下标开始，一共写len个字节
void write(byte[] b, int off, int len) throws IOException
     */
    public static void main(String[] args) throws IOException {
      byte[] bytes = {97,98,99,100,101};
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\java二阶段练习\\lianxi2\\q.txt");
        int i = 0;
        while (true) {
            fileOutputStream.write(bytes,0,2);//从off开始写，写入文件的一共有len个
            fileOutputStream.write(bytes);
            i++;
            if (i==5){
                break;
            }
        }//可以结合while循环做一个循环输出文件
        fileOutputStream.close();
    }
}
