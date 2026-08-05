package com.shennian;

public class preson {
    private  String name;
    private  int gonghao;
    private  double gongzi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGonghao() {
        return gonghao;
    }

    public void setGonghao(int gonghao) {
        this.gonghao = gonghao;
    }

    public double getGongzi() {
        return gongzi;
    }

    public void setGongzi(double gongzi) {
        this.gongzi = gongzi;
    }

    public preson(String name, int gonghao, double gongzi){
    this.name = name;
    this.gonghao = gonghao;
    this.gongzi = gongzi;

    }
    public void eat(){
        System.out.println("吃米饭");
    }
    public void work(){
        System.out.println("工作");
    }
    public preson(){
        System.out.println("空参数被调用");
    }
    public void print(){
        System.out.print("姓名："+this.name+" ");
        System.out.print("工号："+this.gonghao+" ");
        System.out.print("工资："+this.gongzi+" ");
    }
}