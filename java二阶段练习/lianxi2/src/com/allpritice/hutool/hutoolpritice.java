package com.allpritice.hutool;

import cn.hutool.http.HttpUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//详细介绍请看io中的climbhttp
public class hutoolpritice {
    public static void main(String[] args) throws IOException {
        String s = HttpUtil.get("https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0");
        ArrayList<String> getconnent = getconnent(s,"([\\u4e00-\\u9fa5a-zA-Z0-9]{4})(，|。)",1);
        System.out.println(getconnent);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\githup仓库\\java二阶段练习\\lianxi2\\src\\百家姓"));
        byte[] bytes = new byte[1024];

        for (String a:getconnent){
            while ((a!=null)){
                bufferedWriter.write(a);
               bufferedWriter.newLine();
                break;
            }
        }
        bufferedWriter.close();
    }
    public  static ArrayList<String> getconnent(String fam, String reglx, int index){
        //创建集合存放数据
        ArrayList<String> list = new ArrayList<>();
        //编译一下正则表达式
        Pattern pattern = Pattern.compile(reglx);
        //创建匹配器，绑定长文本
        Matcher matcher = pattern.matcher(fam);
        //遍历
        while (matcher.find()){
            list.add(matcher.group());
        }
        return  list;
    }
}
