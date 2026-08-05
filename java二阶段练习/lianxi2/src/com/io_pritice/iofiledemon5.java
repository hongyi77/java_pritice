package com.io_pritice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//此练习，记录了拷贝视频变快的方式
//8192表示8.192kB,可以理解为一个大卡车，每次能运8.192kB视频的容量
public class iofiledemon5 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:\\视频\\zombie_video_part3.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\java二阶段练习\\lianxi2\\小视频1.mp4");
        byte [] bytes = new byte[8192];//卡车的容量
        int leng;
        while ((leng= fis.read(bytes))!=-1){
            fos.write(bytes,0,leng);
            //System.out.println(new String(bytes,0,leng));
            //18行批注语句可以获取视频最原本的状态
        }
        //要养成关闭资源的习惯
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("共花费"+(end-start)+"ms的时间");
    }
}
