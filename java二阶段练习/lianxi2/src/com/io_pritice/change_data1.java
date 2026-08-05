package com.io_pritice;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class change_data1 {
    public static void main(String[] args) throws IOException {
        //遍历文件的内容
        FileReader fi = new FileReader("D:\\githup仓库\\java二阶段练习\\lianxi2\\t.txt");
        StringBuilder str = new StringBuilder();
        try(fi){
            int len;
            while ((len= fi.read())!=-1){
                str.append((char) len);
            }
           // System.out.println(str);
        }
        //分割字符，获取数字
        Integer[] integers = Arrays.stream(str.toString().split("-")).map(Integer::parseInt).sorted()
                .toArray(Integer[]::new);
       FileWriter fw = new FileWriter("D:\\githup仓库\\java二阶段练习\\lianxi2\\t.txt");
        //注意：Arrays在遍历时会产生空格例如1， 2 ，3...像这样
           try (fw) {
               String s = Arrays.toString(integers).replace(", ", "-");
               System.out.println(s);
               String substring = s.substring(1, s.length() - 1);
               System.out.println(substring);
           }

    }
}
