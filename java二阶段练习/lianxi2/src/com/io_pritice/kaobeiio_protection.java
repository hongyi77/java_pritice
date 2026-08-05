package com.io_pritice;

import java.io.*;

//对于文件拷贝的加密和解密
public class kaobeiio_protection {
    public static void main(String[] args) throws IOException {
        /*
        以下为计算方式
         */
        //两者不同显示为true，两者相同显示为false，例如true^true=false,true^false=true,
        //在计算机中，0为false，1为true
        //例如20的二进制为0001 0100，100的十进制为0110 0100
        //20^100=
        //0110 0100  =100
        //0001 0100  =20
        //结果为false,true,true,true,false,false,false,false,对应成数字为
        //0111 0000=112
        /*System.out.println(100^10);  //可以理解为加密 结果为110
        System.out.println(110^10);  //=100^10^10  可以理解为解密   结果为100*/
       /* System.out.println(100^20);  // 结果为112
        System.out.println(112^20);  //  结果为100*/
        //先拷贝一个文件
       /* File file = new File("D:\\图片\\img-7.png");
        FileInputStream fis = new FileInputStream("D:\\图片\\img-7.png");
        FileOutputStream fos = new FileOutputStream("D:\\拷贝\\拷贝2(图片)\\图片1.png");
        try(fis;fos) {
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            System.out.println(file.getName()+"拷贝完成");
        }*/
        //加密实际过程
        //创建一个想要加密的文件
        FileInputStream fis = new FileInputStream("D:\\拷贝\\拷贝2(图片)\\图片2.png");
        //创造一个加密文件的地址
        FileOutputStream fos = new FileOutputStream("D:\\拷贝\\拷贝2(图片)\\图片3.png");
        //加密处理
        int b;
       try (fis;fos){
           while ((b = fis.read())!=-1){
               fos.write(b^2);
               //执行完加密已完成
           }
       }



    }
}
