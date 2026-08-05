package com.io_pritice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//字节输入流 inputStream
//当读到文件末尾了，read方法返回-1

public class iofiledemon3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\java二阶段练习\\lianxi2\\q.txt");
       /* int read = fis.read();
        System.out.println((char)read);
        int read1 = fis.read();
        System.out.println((char) read1);
        int read2 = fis.read();
        System.out.println((char) read2);   单个读取
        fis.close();*/
        //-----------------------------------
        //以下为循环读取----此方法更加方便的读取文件内容
        int b;
        while ((b=fis.read())!=-1){
            System.out.print((char)b);//不可以在输出中再把fis.read再次调用
        }
        fis.close();
    }
}
