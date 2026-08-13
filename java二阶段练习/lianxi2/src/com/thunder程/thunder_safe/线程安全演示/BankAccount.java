package com.thunder程.thunder_safe.线程安全演示;

/**
 * 银行取钱场景 - 更贴近实际的线程安全问题
 * 
 * 多个线程同时从同一个账户取钱，不加锁会导致余额变成负数
 */
public class BankAccount {
    private int balance = 1000;  // 初始余额 1000 元
    private final Object lock = new Object();

    // 取钱方法 - 不加锁版本
    public void withdrawUnsafe(int amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(10);  // 模拟处理时间，让问题更容易复现
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " 取走 " + amount 
                + " 元，余额: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " 取钱失败，余额不足: " + balance);
        }
    }

    // 取钱方法 - 加锁版本
    public void withdrawSafe(int amount) {
        synchronized(lock) {
            if (balance >= amount) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " 取走 " + amount 
                    + " 元，余额: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " 取钱失败，余额不足: " + balance);
            }
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        System.out.println("===== 不加锁（不安全）=====");
        BankAccount account1 = new BankAccount();
        
        Thread[] threads1 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads1[i] = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    account1.withdrawUnsafe(200);  // 每人取3次，每次200
                }
            });
            threads1[i].setName("用户-" + i);
            threads1[i].start();
        }
        try {
            for (Thread t : threads1) t.join();
        } catch (InterruptedException e) {}
        System.out.println("最终余额: " + account1.getBalance() + " (期望 >= 0)");
        System.out.println();

        System.out.println("===== 加锁（安全）=====");
        BankAccount account2 = new BankAccount();
        
        Thread[] threads2 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads2[i] = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    account2.withdrawSafe(200);
                }
            });
            threads2[i].setName("用户-" + i);
            threads2[i].start();
        }
        try {
            for (Thread t : threads2) t.join();
        } catch (InterruptedException e) {}
        System.out.println("最终余额: " + account2.getBalance() + " (期望 >= 0)");
    }
}
