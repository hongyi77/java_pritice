package com.thunder程.thunder_safe.线程安全演示;

/**
 * 用 synchronized 修饰方法 - 等价于 synchronized(this)
 */
public class CounterWithSynchronizedMethod {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        CounterWithSynchronizedMethod counter = new CounterWithSynchronizedMethod();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].setName("线程-" + i);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();     //等待别的线程
        }

        System.out.println("预期结果: 10000");
        System.out.println("实际结果: " + counter.getCount());
        
        if (counter.getCount() == 10000) {
            System.out.println("✅ synchronized方法 方式也正确");
        } else {
            System.out.println("❌ 数据丢失");
        }
    }
}
