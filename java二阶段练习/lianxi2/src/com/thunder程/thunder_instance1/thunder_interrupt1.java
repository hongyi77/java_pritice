package com.thunder程.thunder_instance1;

public class thunder_interrupt1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName()+"被中断"+i);
                break;
            }
            System.out.println(Thread.currentThread().getName()+"正在工作中"+i);
        }
    }
}
