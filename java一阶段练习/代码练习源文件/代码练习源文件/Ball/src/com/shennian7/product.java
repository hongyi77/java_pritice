package com.shennian7;

abstract class product {
    String name; double price; String jian;//jian是一个定义物件的称号
    public  product(){}
    public product(String name, double price, String jian) {
        this.name = name;
        this.price = price;
        this.jian = jian;
    }
    abstract void addtocart();
    abstract double calculatetotalprice(int quantity);//抽象当以了一个数量，用于算最后价格的总价

}
interface shopp{  //设计了一个接口
    void viewcard();//查看购物车
    void checkout();//退出购物车
}

class pendant extends product implements shopp {
    @Override
    public void viewcard() {
        System.out.println("Viewing cart");
    }

    @Override
    public void checkout() {
        System.out.println("Checking out");
    }

    public pendant(String name, double price, String jian) {
        super(name, price, jian);
    }

    @Override
    void addtocart() {
        System.out.println("added:" + name +"  price:"+price+"$"+ "  tu the card." + "----" + jian);
    }

    @Override
    double calculatetotalprice(int quantity) {

        return price * quantity;
    }
}