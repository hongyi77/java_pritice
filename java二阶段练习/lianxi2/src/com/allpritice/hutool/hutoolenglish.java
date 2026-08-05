package com.allpritice.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.http.HttpUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
String path = "D:/githup仓库/java二阶段练习/lianxi2/src/百家姓";

FileUtil.readUtf8String(path);   // 读整个文件为字符串
FileUtil.writeUtf8String("内容", path);  // 写字符串到文件
FileUtil.exist(path);            // 判断文件是否存在
FileUtil.mkdir("D:/newdir");     // 递归创建目录
FileUtil.copy("a.txt", "b.txt", true);  // 复制文件,true=覆盖
FileUtil.del("old.txt");         // 删除文件
 */
//爬取英语四级词汇单词
public class hutoolenglish {
    public static void main(String[] args) {
       // h

        FileUtil.readUtf8String("D:\\英语学习\\CET-词汇整理\\文件_去重合并版.txt");
        FileUtil.copy("D:\\英语学习\\CET-词汇整理\\文件_去重合并版.txt","D:\\githup仓库\\java二阶段练习\\lianxi2\\q.txt",true);

    }
}
