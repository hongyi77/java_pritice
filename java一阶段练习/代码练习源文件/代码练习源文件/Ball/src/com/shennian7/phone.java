package com.shennian7;
public class phone extends product implements shopp{
    @Override
    public void viewcard() {
        System.out.println("-------欢迎光临--------");//查看购物车
    }

    @Override
    public void checkout() {//退出购物车
        System.out.println("您的购物到此结束");
        System.out.println("欢迎下次光临");//
    }

    public phone() {
    }

    public phone(String name, double price, String jian) {
        super(name, price, jian);
    }
    @Override
    void addtocart() {
        System.out.println("added:" + name +"  price:"+price+"$"+ " tu the card." + "----" + jian);
    }

    @Override
    double calculatetotalprice(int quantity) {
        return price * quantity;
    }

}
//别找了，没test类，需要什么自己设置吧,test需要再建一个类
