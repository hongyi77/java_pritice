package com.io_pritice.xvlieliu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class objectionio {
    //反序列编码
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream oj = new ObjectInputStream(new FileInputStream("D:\\githup仓库\\java二阶段练习\\lianxi2\\b.txt"));
        ArrayList<Student> list = (ArrayList<Student>) oj.readObject();
        for (Student student : list) {
            System.out.println(student);
        }
        oj.close();

    }
}
