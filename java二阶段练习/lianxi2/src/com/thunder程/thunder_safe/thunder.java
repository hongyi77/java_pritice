package com.thunder程.thunder_safe;
//有关线程安全的基础概念
public class thunder implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"已经启动");
    }
}
