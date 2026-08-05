package com.io_pritice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class iofiledemon7 {
    //小知识，二进制开始是0就是一个字母，开始是1就是一个汉字，一般汉字为3个字节，字母为一个字节
    public static void main(String[] args) throws IOException {
        FileInputStream fis  = new FileInputStream("D:\\githup仓库\\java二阶段练习\\lianxi2\\q.txt");
        int len;
        byte [] bytes =  new byte[10]; //目前是搬运不了文本，若强行搬运，会出现乱码

        //所以说基础的文本不需要搬运，当拷贝一些视频时，可以使用byte增加效率，但中文会出现乱码
        //解决方法不要用字节流去读取文件
        //注意：当拷贝时不会出现乱码
        while ((len = fis.read())!=-1){
            System.out.print((char) len);
        }
        fis.close();
    }
}
