package com.thunder程.thunder_instance1;

public class text extends Thread {
    @Override
    public void run() {
        System.out.println("111");
        System.out.println(Thread.interrupted());
    }

    public static void main(String[] args) {
        text text = new text();
        Thread thread = new Thread(text);

         thread.start();
    }
}
