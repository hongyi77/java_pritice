package com.thunder程.Runtime_pritice;

public class runablework1 {
    public static void main(String[] args) {
        runablework runablework = new runablework();
        runablework runablework1 = new runablework();
        Thread thread = new Thread(runablework);
        Thread thread2 = new Thread(runablework);
        thread.setName("线程1");
        thread2.setName("线程2");
        thread.start();
        thread2.start();
    }
}
