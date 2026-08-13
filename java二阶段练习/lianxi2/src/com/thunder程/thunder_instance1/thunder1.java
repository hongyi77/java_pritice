package com.thunder程.thunder_instance1;

public class thunder1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
            thunder thunder2 = new thunder();
            Thread thread = new Thread(thunder2);
           try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}