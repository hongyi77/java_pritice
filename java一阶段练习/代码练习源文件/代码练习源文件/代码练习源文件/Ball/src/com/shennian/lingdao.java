package com.shennian;

public class lingdao extends preson {
    private double jiangjin;

    public double getJiangjin() {
        return jiangjin;
    }

    public void setJiangjin(double jiangjin) {
        this.jiangjin = jiangjin;
    }

    public lingdao(String name, int gonghao, double gongzi,double jiangjin) {
        super(name, gonghao, gongzi);
        this.jiangjin = jiangjin;
    }

    @Override
    public void work() {
        super.work();
        System.out.println("管理其他人工作");
    }

    @Override
    public void print() {
        super.print();
        System.out.println("奖金："+getJiangjin());
    }
}
