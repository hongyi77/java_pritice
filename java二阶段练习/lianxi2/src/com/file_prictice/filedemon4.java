package com.file_prictice;

import javax.xml.crypto.Data;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//获取文件的方法
public class filedemon4 {
    public static void main(String[] args) {
        /*
        public long length() 返回文件的大小（字节数量）
        public String getAbsolutePath() 返回文件的绝对路径
        public String getPath()  返回定义文件所使用的路径
        public String getName()  返回文件的名称，带后缀
        public long lastModified()  返回文件最后的修改时间（表示的是时间ms值）
         */


        //length()
        //这个方法只能获取文件的大小，单位是字节（即这个方法无法获取文件夹的大小）
        //如果单位是M，G,可以不断除以1024
        //例如length/1024 得到的是kB，后续是MB，GB
        File file  =new File("D:\\文件实验地\\rrr.rtf");
        long length = file.length();
        System.out.println(length);

        /*File file1 =  new File("D:\\创造");
        long length1 = file1.length();
        System.out.println(length1);*/
        System.out.println("1******************************************");

        //getAbsolutePath()
        File file1 = new File("D:\\java二阶段练习\\lianxi2\\test.txt");
        String absolutePath = file1.getAbsolutePath();
        System.out.println(absolutePath);

        System.out.println("2******************************************");
        //getPath()
        File file2= new File("D:\\java二阶段练习\\lianxi2\\test.txt");
        String path = file2.getPath();
        System.out.println(path);

        System.out.println("3******************************************");
        //getName()
        File file3= new File("D:\\java二阶段练习\\lianxi2\\test.txt");
        String name = file3.getName();
        System.out.println(name);//这个是创造的文件的名字输出

        File file5 =  new File("D:\\文件实验地\\fff");
        String name1 = file5.getName();
        System.out.println(name1);//这个是创造的文件夹的名字输出


        System.out.println("4******************************************");
       //lastModified()
        File file4 = new File("D:\\java二阶段练习\\lianxi2\\test.txt");
        long l = file4.lastModified();
        Date date = new Date(0L);
        long time = date.getTime();
       time = time+l;
       date.setTime(time);
        String[]arr ={"周日","周一","周二","周三","周四","周五","周六"};
        SimpleDateFormat sid = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"+" "+arr[date.getDay()]);
        String format = sid.format(date);
        System.out.println(format);

    }
}
