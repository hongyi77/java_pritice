package com.io_pritice;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
//此方法效率较低，如使用高效率请看change_data1
//修改文件数据
public class chande_data {
    public static void main(String[] args) throws IOException {
        FileReader fis = new FileReader("D:\\githup仓库\\java二阶段练习\\lianxi2\\t.txt");
        try (fis){
            char[] chars = new char[1024];
            //储存数据
            StringBuilder str = new StringBuilder();
            int len;
            while ((len= fis.read(chars))!=-1){
                str.append(new String(chars,0,len));
                //System.out.println(new String(chars,0,len));

            }
            System.out.println(str);
            String s1 = str.toString();
            //以横线切割数据，获取数字
            String[] split = s1.split("-");
            System.out.println(Arrays.toString(split));
            ArrayList<Integer> list = new ArrayList<>();
            for (String a:split){
                int i = Integer.parseInt(a);
               list.add(i);
            }
            Collections.sort(list);
            System.out.println(list);
            FileWriter fos = new FileWriter("D:\\githup仓库\\java二阶段练习\\lianxi2\\t.txt");
            /*System.out.println("排序后的数字为：");
           list.stream().sorted().forEach(s-> System.out.print(""+s));*/

            try(fos){
                for (int i = 0;i<list.size();i++) {
                    if (i==list.size()-1) {
                        fos.write(list.get(i)+"");
                    }else {
                        fos.write(list.get(i)+"-");
                    }
                }
            }



        }
    }
}
