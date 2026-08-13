package com.thunder程.thunder_safe.线程安全演示;

/**
 * 不加锁的 Counter - 观察数据丢失
 */
public class CounterWithoutLock {
    private int count = 0;

    public void increment() {
        count++;  // 非原子操作，多线程下不安全
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        CounterWithoutLock counter = new CounterWithoutLock();

        Thread[] threads = new Thread[10];

        // 启动10个线程，每个执行1000次 +1
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].setName("线程-" + i);
            threads[i].start();
        }

        // 等待所有线程执行完毕
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("预期结果: 10000");
        System.out.println("实际结果: " + counter.getCount());
        
        if (counter.getCount() == 10000) {
            System.out.println("✅ 结果正确");
        } else {
            System.out.println("❌ 数据丢失！丢失了 " + (10000 - counter.getCount()) + " 次");
        }
    }
}
