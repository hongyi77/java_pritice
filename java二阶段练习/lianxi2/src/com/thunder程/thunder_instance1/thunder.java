package com.thunder程.thunder_instance1;

public class thunder implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName() + "已经启动" + i);
           if (i==5){
                try {
                   thunder1 thunder2 = new thunder1();
                   Thread thread = new Thread(thunder2);
                   thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        }
    }
}