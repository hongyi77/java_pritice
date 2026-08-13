package com.thunder程.thunder_instance1;

/**
 * 修复版：正确使用join()
 * 问题：原代码中线程调用了自己的join()，导致死锁
 * 修复：创建两个线程，让主线程等待它们
 */
public class thunder_fixed {

    /**
     * 方式1：在主线程中join两个线程（最常见）
     */
    public static void demo_main_join() throws InterruptedException {
        // 线程1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "线程1");

        // 线程2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "线程2");

        t1.start();
        t2.start();

        // 主线程等待两个子线程执行完毕
        t1.join();
        t2.join();

        System.out.println("所有线程执行完毕！");
    }

    /**
     * 方式2：线程A等待线程B执行完毕再继续（join在子线程中用）
     */
    public static void demo_sub_join() throws InterruptedException {
        final Thread[] t2Ref = new Thread[1];

        t2Ref[0] = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("[线程2] " + i);
            }
        }, "线程2");

        Thread t1 = new Thread(() -> {
            // 先启动线程2
            t2Ref[0].start();
            // 然后等待线程2执行完毕
            try {
                t2Ref[0].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程2结束后，线程1再继续
            System.out.println("[主线程] 线程2执行完毕，线程1继续");
            for (int i = 0; i < 5; i++) {
                System.out.println("[线程1] " + i);
            }
        }, "线程1");

        t1.start();
        t1.join();
    }

    /**
     * 方式3：多个线程依次join（顺序执行）
     */
    public static void demo_sequential_join() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("线程1: " + i);
            }
        }, "线程1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("线程2: " + i);
            }
        }, "线程2");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("线程3: " + i);
            }
        }, "线程3");

        // 顺序执行：t1 -> t2 -> t3
        t1.start();
        t1.join();  // 等t1完

        t2.start();
        t2.join();  // 等t2完

        t3.start();
        t3.join();  // 等t3完

        System.out.println("全部完成！");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 方式1：主线程等所有子线程 ===");
        demo_main_join();
        System.out.println();

        System.out.println("=== 方式2：子线程间join ===");
        demo_sub_join();
        System.out.println();

        System.out.println("=== 方式3：顺序执行join ===");
        demo_sequential_join();
    }
}
