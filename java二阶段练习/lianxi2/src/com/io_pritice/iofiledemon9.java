package com.io_pritice;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
Java中编码的方法
String类中的方法 说明
public byte[] getBytes() 使用默认方式进行编码
public byte[] getBytes(String charsetName) 使用指定方式进行编码

Java中解码的方法
String类中的方法 说明
String(byte[] bytes) 使用默认方式进行解码
String(byte[] bytes, String charsetName) 使用指定方式进行解码

配套关键补充（结合上一页知识点）
1.Windows简体系统默认编码为 GBK，也就是界面里的ANSI
2.编码：String → byte[]；解码：byte[] → String
3.编解码字符集不一致会产生乱码
 */
public class iofiledemon9 {
    public static void main(String[] args) throws UnsupportedEncodingException {
      String str = "a1你哟";
       byte[] bytes = str.getBytes();

        String str1 = "a1你哟";
        byte[] bytes1 = str1.getBytes("GBK");

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes1));

        String a = new String(bytes);
        String b = new String(bytes1);

        System.out.println(a);
        System.out.println(b);//GBK编码
    }
}
