package com.thunder程.thunder_instance1;

public class thunder2 {
    public static void main(String[] args) {
        thunder thunder = new thunder();
        thunder thunder1 = new thunder();
        Thread thread = new Thread(thunder);
        Thread thread1 = new Thread(thunder1);
        thread.setName("线程1");
        thread1.setName("线程2");
        thread.start();
        thread1.start();


    }
}