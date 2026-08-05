package com.thunder程.thread_pritice;

public class threadwork1{
    public static void main(String[] args) {
        threadwork thread = new threadwork();
        threadwork thread1 = new threadwork();
        thread.setName("线程1");
        thread1.setName("线程2");
        thread.start();
        thread1.start();

    }
}
