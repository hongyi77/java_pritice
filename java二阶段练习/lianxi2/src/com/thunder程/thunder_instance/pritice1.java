package com.thunder程.thunder_instance;

public class pritice1 {
    public static void main(String[] args) {
        thunder_pritice1 t1 = new thunder_pritice1();
        thunder_1 t2 = new thunder_1();
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        thread.setName("香蕉");   //1000毫秒
        thread1.setName("苹果");//500毫秒
        thread.start();
        thread1.start();
    }
}
