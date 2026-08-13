package com.thunder程.thunder_instance1;

public class thunder_interrupt2 {
    public static void main(String[] args) throws InterruptedException {
        thunder_interrupt th = new thunder_interrupt();
        thunder_interrupt1 th1 = new thunder_interrupt1();
        Thread thread = new Thread(th);
        Thread thread1 = new Thread(th1);
        System.out.println(thread.isInterrupted());
        System.out.println(thread1.isInterrupted());
        thread.setName("线程1");
        thread1.setName("线程2");
        thread.start();
        thread1.start();

            System.out.println("请稍后，正在加载中");
            thread.sleep(2000);
            thread.interrupt();
            thread1.interrupt();
            System.out.println(thread.isInterrupted());
            System.out.println(thread1.isInterrupted());
        if (thread.isInterrupted()&&thread1.isInterrupted()){
            System.out.println("加载成功");
        }else {
            System.out.println("程序繁忙，请重新加载");
        }



    }
}
