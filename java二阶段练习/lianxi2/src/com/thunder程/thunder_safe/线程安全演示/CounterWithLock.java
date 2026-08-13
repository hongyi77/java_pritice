package com.thunder程.thunder_safe.线程安全演示;

/**
 * 加锁的 Counter - 数据一致
 */
public class CounterWithLock {
    private int count = 0;
    private final Object lock = new Object();  // 自定义锁对象

    public void increment() {
        synchronized(lock) {          // 加锁
            count++;                  // 只有拿到锁的线程才能执行这里
        }                             // 解锁
    }

    public int getCount() {
        synchronized(lock) {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterWithLock counter = new CounterWithLock();

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
            t.join();
        }

        System.out.println("预期结果: 10000");
        System.out.println("实际结果: " + counter.getCount());
        
        if (counter.getCount() == 10000) {
            System.out.println("✅ 结果正确，数据一致");
        } else {
            System.out.println("❌ 数据丢失");
        }
    }
}
