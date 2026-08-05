package com.allpritice.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//该项目是一个爬取网页的项目
//简单写法请看hutool-hutoolpritice的写法
public class climbhttp {
    public static void main(String[] args) throws IOException {
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        //错误示范会拿到em》*类似这样的符号
        //ArrayList<String> getconnent = getconnent(climb(familyNameNet), "(.{4})(，|。)",0);//
        ArrayList<String> getconnent = getconnent(climb(familyNameNet),"([\\u4e00-\\u9fa5a-zA-Z0-9]{4})(，|。)",1);
        //“\u4e00-\u9fa5”指的是所有中文汉字，”a-zA-Z0-9“大小写字母和数字
        System.out.println(getconnent);
    }

    //转化为正则表达式进行编译 Pattner
    public  static  ArrayList<String> getconnent(String fam, String reglx,int index){
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

    //爬取逻辑
    public  static String climb(String fanily) throws IOException {
        StringBuilder sb = new StringBuilder();
        //将该网址进行编译和预存
        URL url = new URL(fanily);
        //获取该网址的内容
        URLConnection conn = url.openConnection();
        //创建字符流进行内容的读取
        InputStreamReader fis = new InputStreamReader(conn.getInputStream());
        int len;
        while ((len = fis.read())!=-1){
            //将内容爬取到本地
            sb.append((char)len);
        }
        //关闭资源
        fis.close();
        //转化为字节数组
        return sb.toString();

        /*String html = sb.toString();
// 匹配 <div class="poem-detail-main-text">...</div> 里面的内容
        Pattern poemPattern = Pattern.compile("<div\\s+class=\"poem-detail-main-text\"[^>]*>(.*?)</div>", Pattern.DOTALL);
        Matcher poemMatcher = poemPattern.matcher(html);
        String poemText = "";
        if (poemMatcher.find()) {
            String inner = poemMatcher.group(1);
            // 再去掉里面的 HTML 标签，只剩纯文字
            poemText = inner.replaceAll("<[^>]+>", "").trim();
        }

        return poemText; // 返回的是纯文字，不是 HTML*/
    }
}
