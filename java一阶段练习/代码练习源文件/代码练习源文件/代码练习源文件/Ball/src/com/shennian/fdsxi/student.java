package com.shennian.fdsxi;
public class student extends person {
    public student() {
    }

    public student(int id, String name, int age, String grade) {
        super(id, name, age, grade);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public static String header() {
        return String.format("%-8s %-10s %-6s %-10s ", "学号", "姓名", "年龄", "班级");
    }
}