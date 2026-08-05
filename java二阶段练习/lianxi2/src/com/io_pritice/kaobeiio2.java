package com.io_pritice;
//字符换种输入流 --
//字符缓冲输出流 --基本流换成高级流
//两种底层自带了长度为8192地缓冲区高性能

import java.io.*;

/*
独有方法
readline（）读取一行数据，没有数据可读。会返回null BufferedReader的特有方法
newline（） 跨平台的换行   BufferedWriter的特有方法
 */
public class kaobeiio2 {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\githup仓库\\java二阶段练习\\lianxi2\\c.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\githup仓库\\java二阶段练习\\lianxi2\\b.txt",true));
        try(bw;br) {
            int len;
            byte[] bytes = new byte[8192];
            /*String line = br.readLine();
            System.out.println(line);
            String line1 = br.readLine();
            System.out.println(line1);
            String line2 = br.readLine();
            System.out.println(line2);//反复的去调用*/    //该步骤为阅读文件中的数据即BufferedReader

            String line;
            while ((line= br.readLine())!=null){
                System.out.println(line);
            }

            bw.write("你嘴角上扬的样子，百度搜索不到");
            bw.newLine();  //跨平台换行  无论是Windows还时mac都支持
            bw.write("如果以后我结婚了你一定要来，没有新娘会很尴尬");
            bw.newLine();






        }

    }

}
