package com.练习;

abstract class shape{
    double length;
    double height;
    public abstract double area();
}
public class rentangle extends shape{
    public rentangle(double length,double height) {
        this.length = length;
        this.height = height;

    }
    public double area(){
        return height*length;
    }
}
class zhouchang extends shape{
    @Override
    public double area() {
        return Math.PI*length*height/4;
    }

    public zhouchang(double length, double height){
        this.height =height;
        this.length =length;
    }

}
