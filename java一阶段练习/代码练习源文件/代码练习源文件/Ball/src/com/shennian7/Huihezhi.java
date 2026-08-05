package com.shennian7;

import java.util.Random;

public class Huihezhi {
    private String name;
    private int blood;
    public  Huihezhi(){};
    public Huihezhi(String name,int blood){
        this.name = name;
        this.blood = blood;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }
    public void attract(String role){
        Random random = new Random();

        if (blood < 0) {
            blood = 0;
            System.out.println(this.getName()+"已经死亡");
        }

            int hurt = random.nextInt(15)+1;
            blood = blood - hurt;
            System.out.println(this.getName() + "被"+role+"攻击了一下损失了" + hurt + "血量");



    }
    public void attract1(String role){
        Random random = new Random();

        if (blood < 0) {
            blood = 0;
            System.out.println(this.getName()+"已经死亡");
        }

        int hurt = random.nextInt(20)+1;
        blood = blood - hurt;
        System.out.println(this.getName() + "被"+role+"攻击了一下损失了" + hurt + "血量");



    }
}
