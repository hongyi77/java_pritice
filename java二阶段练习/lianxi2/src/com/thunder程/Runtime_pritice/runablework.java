package com.thunder程.Runtime_pritice;

public class runablework implements Runnable{
//展示sleep使用方法以及更简洁的方法
    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println(Thread.currentThread().getName()+ "线程启动" + i);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
