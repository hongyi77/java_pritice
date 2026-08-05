package com.io_pritice;
//字节输出流 outputStream
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//从第九个练习开始字符流
public class iofiledemon {
    public static void main(String[] args) throws IOException{
        //1.创建对象
        //写出输出流outputStream
        //本地文件file
        //2.写出数据
        //3.释放资源
       FileOutputStream fos = new FileOutputStream("D:\\java二阶段练习\\lianxi2\\t.txt");
       //FileOutputstream方法本质是先创建一个文件，然后再文件中写入b，98为哈希码值
        //2.若原本文件
       fos.write(98);
       fos.write(97);
       fos.close();
    }
}
