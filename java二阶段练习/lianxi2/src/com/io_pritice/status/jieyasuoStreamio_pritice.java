package com.io_pritice.status;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
//将没有解压的文件加压到目标文件中
public class jieyasuoStreamio_pritice {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\代码练习源文件.zip");
        File goal = new File("D:\\文件实验地",src.getName());
        changperviousFile(src,goal);
    }
    public static void changperviousFile(File src,File goal) throws IOException {
       ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
       ZipEntry entry;
       while ((entry=zis.getNextEntry())!=null){
           System.out.println(entry);
           if (entry.isDirectory()){
               //按照文件夹的方式去处理
               File file =new File(goal,entry.toString());
               file.mkdirs();
           }else {
               //按照读取压缩包的文件，并把它放在dest文件中
               FileOutputStream fos = new FileOutputStream(new File(goal,entry.toString()));
               int b;
               byte[] bytes =new byte[1024];
               while((b= zis.read(bytes))!=-1){
                   fos.write(bytes,0,b);
               }
               fos.close();
               //表示压缩包的一个文件处理完毕了
               zis.closeEntry();
           }
       }
       zis.close();
    }
}
