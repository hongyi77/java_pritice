package com.io_pritice.xvlieliu;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private  int age;
    private  String addersds;
    public Student(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddersds() {
        return addersds;
    }

    public void setAddersds(String addersds) {
        this.addersds = addersds;
    }

    public Student(String name, int age, String addersds) {
        this.name = name;
        this.age = age;
        this.addersds = addersds;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addersds='" + addersds + '\'' +
                '}';
    }
}
