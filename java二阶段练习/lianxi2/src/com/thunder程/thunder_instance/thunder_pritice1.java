package com.thunder程.thunder_instance;
//因为thunder的用法在复杂业务上不常用，所以联系都以Runable和callable这两个接口实例为主
public class thunder_pritice1 implements Runnable {
//此线程练习是名字的输出和实现的练习
    @Override
    public void run() {
        Thread th = new Thread();
        Thread thread = th.currentThread();
        for (int i= 0;i<10;i++) {
            System.out.println(thread.getName()+"启动"+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
