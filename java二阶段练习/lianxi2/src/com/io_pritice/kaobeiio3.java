package com.io_pritice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class kaobeiio3 {
    //对出师表的文章顺序还原一下
    //对被一行最左侧的数字进行排序
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\githup仓库\\java二阶段练习\\lianxi2\\dd.txt"));
        String a;
        ArrayList<String> list = new ArrayList<>();
        //读取数据
        try(br){
            while ((a= br.readLine())!=null){
                list.add(a);
            }
        //排列数据
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //获取o1和o2的序号
                int i = Integer.parseInt(o1.split("\\.")[0]);
                int i1 = Integer.parseInt(o2.split("\\.")[0]);
                return i-i1;
            }
        });
        //写出
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\githup仓库\\java二阶段练习\\lianxi2\\b.txt"));
        for (String str: list){
            bw.write(str);
            bw.newLine();
        }
        bw.close();
    }
}
