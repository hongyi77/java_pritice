package com.io_pritice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class iofiledemon4 {
    //此练习可以拷贝文件夹中的一些资源，但是速率较慢，虽下面有解决方法，但详细步骤请看iofiledemon5
    public static void main(String[] args) throws IOException {
        // 记录拷贝开始时间（毫秒级精度）
        long start = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("D:\\视频\\scene1_summer_afternoon.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\java二阶段练习\\lianxi2\\小视频.mp4");

        /*int len;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }//该方法需要花费： 26795 ms*/

  //另外提醒一下，你当前是用逐字节读写（read() 返回单个 byte），效率很低。如果是大文件，建议用缓冲区：
  byte[] buffer = new byte[8192];
  int len;
  while ((len = fis.read(buffer)) != -1) {
      fos.write(buffer, 0, len);
      //如果使用缓冲区，只需要花费20-30毫秒不等
  }

        fos.close();
        fis.close();

        // 记录拷贝结束时间，计算总耗时
        long end = System.currentTimeMillis();
        System.out.println("拷贝耗时: " + (end - start) + " ms");
    }
}
