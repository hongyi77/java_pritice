package com.thunder程.thunder_safe;

public class mimaopritice {
    /*创建 Account 类，有 balance 属性和 transfer 方法
    用 synchronized 保证转账安全
    创建10个线程，每个线程执行100次转账
    用 join() 等待所有线程完成
    打印最终余额，*/
    // 初始余额 10000 元
// 每个线程转账 100 次，每次转出 10 元
// 如果余额不足，跳过本次转账
     private int blance=10000; //金额总数
    public int getBlance() {//获取金额的方法
        return blance;
    }
    public synchronized void transfer(int bill){//处理线程钱的逻辑    synchronized保护线程，给线程上锁，保护数据
        if (blance>=bill){
            blance -= bill;
            System.out.println(Thread.currentThread().getName()+"支付"+bill+"元"+"余额还剩"+blance+"元");
        }else {
            System.out.println("账户余额不足");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        mimaopritice mi =  new mimaopritice();
        for (int i = 0; i <10 ; i++) {
          threads[i] = new Thread(()->{for (int j = 0;j<100;j++){
               mi.transfer(10);
           }});
           threads[i].setName("线程"+i);
           threads[i].start();
        }
        for (Thread t: threads) {
            t.join();
        }
        System.out.println("最终的余额还剩"+mi.getBlance());
    }

}
