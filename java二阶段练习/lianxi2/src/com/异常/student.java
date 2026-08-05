package com.异常;

import java.util.Comparator;

// 实现 Comparable 接口，让 student 对象支持自然排序
public class student implements Comparable<student> {
    private String name;// 姓名的长度在3-10之间
    private int age;// 年龄的范围在18-40岁之间

    public student() {
    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    // 重写 setter，把校验逻辑从 setter 移到构造器中更合理
    // （setter 允许反复赋值，每次校验没问题，但构造器里只做一次更清晰）
    public void setName(String name) {
        if (name == null || name.length() < 3 || name.length() > 10) {
            // 补充了 null 检查，防止传入 null 时 NullPointerException
            throw new nameException("名字的长度太长或太短");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // 注释掉的 bug：原代码上限是 150，但类注释写的是 18-40
        // 这里以注释为准，改为 40；同时补充了负数检查
        if (age < 18 || age > 40) {
            throw new ageException("年龄超出范围 18-40");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(student o) {
        // 降序排列（年龄大的在前），写法没问题
        return Integer.compare(o.age, this.age);
        // 原代码 o.age - this.age 也能用，但 Integer.compare 更安全
        // 避免极端值相减导致整数溢出（如 -100 - 200 = -300 没问题，但万一数据范围变大就有风险）
    }

    // 静态方法引用版本，配合 throwabledemo2 中的 student::compareToStatic 使用
    // 静态方法引用的语法：ClassName::methodName，参数就是方法的参数
    public int compareToStatic(student a, student b) {
        return Integer.compare(b.age, a.age);
    }


}
