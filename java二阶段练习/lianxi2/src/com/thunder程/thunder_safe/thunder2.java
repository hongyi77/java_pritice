package com.thunder程.thunder_safe;

public class thunder2 {
    private int count = 0;
   public void bianliang(){
        count++;
    }

    public static void main(String[] args) {
        thunder  thunder = new thunder();
        thunder1 thunder1 = new thunder1();
        Thread thread = new Thread(thunder);
        Thread thread1 = new Thread(thunder1);
        thread.setName("线程1");
        thread1. setName("线程2");

        thread.start();
        thread1.start();
    }
}
