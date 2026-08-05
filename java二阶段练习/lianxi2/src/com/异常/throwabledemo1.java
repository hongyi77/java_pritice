package com.异常;

import java.util.*;
import java.util.function.*;

public class throwabledemo1 {
    public static void main(String[] args) {
        // === Java 方法引用（Method Reference）===
        // 方法引用是函数式接口的语法糖，配合 :: 运算符使用
        // 让 Lambda 表达式更简洁，前提是 Lambda 体刚好就是调用某个已有方法

        // ---------- 1. 指向静态方法的引用 ----------
        // 格式: ClassName::staticMethod
        // Lambda 参数直接传给静态方法
        Comparator<Integer> comp1 = Integer::compare;
        // 等价于 (x, y) -> Integer.compare(x, y)
        System.out.println("静态方法引用 compare(1, 2) = " + comp1.compare(1, 2));

        // ---------- 2. 指向已知对象的实例方法的引用 ----------
        // 格式: instanceReference::methodName
        // 第一个参数（或无参）成为方法调用的对象
        String str = "hello";
        Supplier<String> sup = str::toUpperCase;
        // 等价于 () -> str.toUpperCase()
        System.out.println("对象实例方法引用 = " + sup.get());

        // ---------- 3. 指向任意类型实例方法的引用 ----------
        // 格式: ClassName::methodName
        // Lambda 的第一个参数成为方法调用的对象，其余参数传给方法
        Comparator<String> comp2 = String::compareToIgnoreCase;
        // 等价于 (s1, s2) -> s1.compareToIgnoreCase(s2)
        System.out.println("任意对象实例方法引用 compareToIgnoreCase = " + comp2.compare("abc", "ABC"));

        // ---------- 4. 指向构造方法的引用 ----------
        // 格式: ClassName::new

        // 4a. 无参构造
        Supplier<String> sup2 = String::new;
        // 等价于 () -> new String()
        System.out.println("无参构造引用 = \"" + sup2.get() + "\"");

        // 4b. 带单参构造 — 数组构造引用
        // 格式: IntFunction<R> -> R apply(int n)
        IntFunction<String[]> arrCreator = String[]::new;
        // 等价于 n -> new String[n]
        String[] arr = arrCreator.apply(3);
        System.out.println("数组构造引用 new String[3] 长度 = " + arr.length);

        // 4c. 多参数构造（BiFunction）
        BiFunction<String, Integer, Student> studentFactory = Student::new;
        // 等价于 (name, age) -> new Student(name, age)
        Student s = studentFactory.apply("张三", 20);
        System.out.println("多参构造引用 = " + s);

        // ---------- 补充：常见实战示例 ----------

        // forEach + 方法引用
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);
        // 等价于 list.forEach(item -> System.out.println(item));

        // map + 方法引用
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
        // 等价于 names.stream().map(s -> s.toUpperCase()).forEach(...)

        // Consumer / Predicate / BiFunction 等函数式接口与方法引用搭配
        Consumer<String> cons = System.out::println;
        Predicate<String> pred = Objects::nonNull;
        BiPredicate<String, String> biPred = Objects::equals;
        Function<Student, String> fn = Student::getName;
        // 假设 Student 有 getName() 方法
    }
}

// 辅助类
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}
