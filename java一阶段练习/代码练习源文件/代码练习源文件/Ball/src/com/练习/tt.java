package com.练习;

abstract class eat{
    String name;int age;

    public eat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String eats();
}
interface xingdong{
    public void zishi();
}
 public class tt extends eat implements xingdong {
    public tt(String name,int age){
      super(name, age);
    }
     @Override
     public void zishi() {
         System.out.println("蛙泳");

     }

     @Override
     public String eats() {
         System.out.println("吃虫子");
         return "";
     }
 }
 class yy extends eat implements xingdong{
     public yy(String name, int age) {
         super(name, age);
     }

     @Override
     public void zishi() {
         System.out.println("狗刨式游泳");
     }

     @Override
     public String eats() {
         System.out.println("吃骨头");
         return "";
     }
 }
class bb extends eat implements xingdong{
    public bb(String name, int age) {
        super(name, age);
    }

    @Override
    public void zishi() {
        System.out.println("不会游泳");
    }

    @Override
    public String eats() {
        System.out.println("吃胡萝卜");
        return "";
    }
}
 class  text{
     public static void main(String[] args) {
         tt t = new tt("小青蛙",1);
         System.out.println("姓名:"+t.name+" "+"年龄:"+ t.age+"岁");
         t.zishi();t.eats();
         yy t1= new yy("小狗",2);
         System.out.println("姓名:"+t1.name+" "+"年龄:"+ t1.age+"岁");
         t1.zishi();t1.eats();
         bb t2 =new bb("小白兔",3);
         System.out.println("姓名:"+t2.name+" "+"年龄:"+ t2.age+"岁");
         t2.zishi();t2.eats();
     }

 }