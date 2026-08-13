package com.thunder程.thunder_safe;

public class thunder1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"已经启动");
    }
}
