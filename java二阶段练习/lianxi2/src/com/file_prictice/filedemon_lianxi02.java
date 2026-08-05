package com.file_prictice;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class filedemon_lianxi02 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        File file = new File("D:\\文件实验地");
       Set<Map.Entry<String,Integer>> entries = map.entrySet();
        File[] files = file.listFiles();
       int i = 0;int j =0;int p =0;
        for (File file1:files){
           if (file1.getName().endsWith(".txt")){
               i++;
           } else if (file1.getName().endsWith(".doc")) {
               j++;
           }else if (file1.getName().endsWith(".jpg")){
               p++;
           }
        }
        map.put("txt文件",i);
        map.put("doc文件",j);
        map.put("jpg文件",p);
        for (Map.Entry<String, Integer> map1:entries) {
          String  key = map1.getKey();
          int  value = map1.getValue();
            System.out.println(key+"在D:\\文件实验地这个文件夹中一共有"+value+"个");
            // System.out.println(" 该文件 " + key + " 有  " + value + "  个");
        }
    }
}
