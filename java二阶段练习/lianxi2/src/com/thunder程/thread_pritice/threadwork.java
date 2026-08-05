package com.thunder程.thread_pritice;
//较为简单的线程继承方式
public class threadwork extends Thread{
    //重构run方法 在run方法中写出你想要的逻辑
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(getName()+"hello world");
        }
        super.run();
    }
}
