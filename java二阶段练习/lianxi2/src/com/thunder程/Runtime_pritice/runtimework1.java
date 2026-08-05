package com.thunder程.Runtime_pritice;

public class runtimework1 {
    public static void main(String[] args) {
        runtimework re = new runtimework();
        Thread thread = new Thread(re);
        Thread thread1 = new Thread(re);
        thread.setName("线程1");
        thread.setName("线程2");
        thread.start();
        thread1.start();

    }
}
