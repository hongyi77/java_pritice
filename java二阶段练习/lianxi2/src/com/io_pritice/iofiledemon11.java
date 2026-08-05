package com.io_pritice;

import java.io.FileReader;
import java.io.IOException;

public class iofiledemon11 {
    public static void main(String[] args) throws IOException {
        FileReader fis = new FileReader("D:\\githup仓库\\java二阶段练习\\lianxi2\\q.txt");
        //主要把编码变成十进制作为返回值
        char [] chars = new char[2];//承装
        int len;
        while ((len=fis.read(chars))!=-1){
            System.out.println(new String(chars,0,len));//转变字符集
        }
        //释放资源
        fis.close();
    }
}
