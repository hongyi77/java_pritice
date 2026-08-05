package com.shennian7;
//Huihezhi
public class test {
    public static void main(String[] args) {
       Huihezhi role = new Huihezhi("孙悟空",60);
      Huihezhi role1 = new Huihezhi("杨戬",55);
        System.out.println("角色对局信息");
        System.out.println("角色:"+role.getName()+"  血量"+role.getBlood()+"  攻击力"+"5-15之间");
        System.out.println("角色:"+role1.getName()+"  血量"+role1.getBlood()+"  攻击力"+"10-20之间");


       while (true){
           role.attract(role1.getName());
           role1.attract1(role.getName());
       if (role.getBlood()<=0){
           System.out.println("此时"+role1.getName()+"血量为零");
           System.out.println(role.getName()+"获胜");
           break;
       } else if (role1.getBlood()<=0) {
           System.out.println("此时"+role.getName()+"血量为零");
           System.out.println(role1.getName()+"获胜");
           break;
       }
       }

    }
}
