package com.io_pritice.xvlieliu;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//序列编码   //将一个个学生对象封装加密
public class objiectio {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        Student student = new Student("张三",19,"北京");
        Student student1 = new Student("李四",26,"杭州");
        Student student2 = new Student("王五",30,"上海");
        Student student3 = new Student("赵六",42,"武汉");
        Collections.addAll(list,student,student1,student2,student3);
       ObjectOutputStream obo = new ObjectOutputStream(new FileOutputStream("D:\\githup仓库\\java二阶段练习\\lianxi2\\b.txt"));
        obo.writeObject(list);
        obo.close();
    }
}
