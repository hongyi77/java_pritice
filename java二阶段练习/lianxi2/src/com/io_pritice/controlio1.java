package com.io_pritice;

import java.io.*;
import java.nio.file.Path;

public class controlio1 {
    public static void main(String[] args) throws IOException {
        //int count = 0;
        /*File file = new File(String.valueOf(Path.of(a)));
        boolean newFile = file.createNewFile();
        System.out.println(newFile);*/

        BufferedReader br = new BufferedReader(new FileReader("D:\\githup仓库\\java二阶段练习\\lianxi2\\count.txt"));
       try (br){
           String s = br.readLine();
           int i = Integer.parseInt(s);
               i++;
           if (i<=3){
               System.out.println("你的软件本次可正常使用，还有"+(3-i)+"次免费使用的机会");

           }else {
               System.out.println("请付费");
               i =3;
           }
           BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\githup仓库\\java二阶段练习\\lianxi2\\count.txt"));
           bw.write(i+"");
           bw.close();
       }catch (NumberFormatException e){
           System.out.println("出现错误");
       }
    }
}
