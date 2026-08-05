package com.shennian7;

public class text1 {
    public static void main(String[] args) {
        product thing = new pendant("冰墩墩",20.8,"冬奥会的挂件");
        product thing1 = new phone("华为proMAX",15000,"荣耀卫龙15系统");
        phone thin = (phone) thing1;
        thin.viewcard();
        thing1.addtocart();
        thing.addtocart();
        System.out.println("此次"+thing.name+"("+ thing.jian+")"+"需要支出"+thing.calculatetotalprice(5)+"元");
        System.out.println("此次"+thing1.name+"("+ thin.jian+")"+"需要支出"+thing1.calculatetotalprice(2)+"元");
        thin.checkout();;


    }
}