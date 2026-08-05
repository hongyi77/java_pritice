// Java线程实战代码集合
// 作者：Sapiens AI | 适合零基础学习者
// 保存为：ThreadExamples.java，编译运行验证

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadExamples {

    // ============================================================
    // 示例1：继承Thread类
    // ============================================================
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }
    }

    // ============================================================
    // 示例2：实现Runnable接口（推荐）
    // ============================================================
    static class MyRunnable implements Runnable {
        private final String name;
        public MyRunnable(String n) { name = n; }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + ": " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }
    }

    // ============================================================
    // 示例3：实现Callable接口（带返回值）
    // ============================================================
    static class MyCallable implements Callable<Integer> {
        private final int id;
        public MyCallable(int i) { id = i; }
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return id * 10;
        }
    }

    // ============================================================
    // 示例4：synchronized同步方法
    // ============================================================
    class SynchronizedCounter {
        private int count = 0;
        public synchronized void increment() { count++; }
        public synchronized int getCount() { return count; }
    }

    // ============================================================
    // 示例5：synchronized代码块
    // ============================================================
    class BlockCounter {
        private int count = 0;
        private final Object lock = new Object();
        public void increment() {
            synchronized(lock) { count++; }
        }
        public int getCount() {
            synchronized(lock) { return count; }
        }
    }

    // ============================================================
    // 示例6：ReentrantLock（更灵活的锁）
    // ============================================================
    class LockCounter {
        private int count = 0;
        private final ReentrantLock lock = new ReentrantLock();
        public void increment() {
            lock.lock();
            try { count++; } finally { lock.unlock(); }
        }
        public int getCount() {
            lock.lock();
            try { return count; } finally { lock.unlock(); }
        }
    }

    // ============================================================
    // 示例7：volatile关键字
    // ============================================================
    volatile boolean flag = false;

    // ============================================================
    // 示例8：生产者-消费者（BlockingQueue）
    // ============================================================
    class ProducerConsumer {
        private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        static class Producer implements Runnable {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        String data = "Item-" + i;
                        queue.put(data);
                        System.out.println(Thread.currentThread().getName() + " 生产: " + data);
                        Thread.sleep(200);
                    } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
            }
        }

        static class Consumer implements Runnable {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        String data = queue.take();
                        System.out.println(Thread.currentThread().getName() + " 消费: " + data);
                        Thread.sleep(300);
                    } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            executor.submit(new Producer());
            executor.submit(new Producer());
            executor.submit(new Consumer());
            executor.submit(new Consumer());
            Thread.sleep(5000);
            executor.shutdown();
        }
    }

    // ============================================================
    // 示例9：线程池使用
    // ============================================================
    static class ThreadPoolDemo {
        public static void main(String[] args) {
            // 固定5个线程的线程池
            ExecutorService pool = Executors.newFixedThreadPool(5);

            // 提交多个任务
            for (int i = 0; i < 20; i++) {
                final int taskId = i;
                pool.submit(() -> {
                    System.out.println("任务" + taskId + "由" +
                        Thread.currentThread().getName() + "执行");
                    try { Thread.sleep(500); } catch (InterruptedException e) {}
                });
            }

            // 优雅关闭
            pool.shutdown();
            try { if (!pool.awaitTermination(60, TimeUnit.SECONDS)) pool.shutdownNow(); }
            catch (InterruptedException e) { pool.shutdownNow(); Thread.currentThread().interrupt(); }
        }
    }

    // ============================================================
    // 示例10：CompletableFuture（异步编程）
    // ============================================================
    static class CompletableFutureDemo {
        public static void main(String[] args) {
            CompletableFuture.supplyAsync(() -> {
                System.out.println("任务1在：" + Thread.currentThread().getName());
                Thread.sleep(1000);
                return "结果1";
            })
            .thenApply(r -> r + " -> 处理")
            .thenAcceptAsync(System.out::println, CompletableFuturePool.commonPool());
        }
    }

    // ============================================================
    // 主测试方法
    // ============================================================
    public static void main(String[] args) {
        System.out.println("================== Java线程示例集合 ==================\n");

        System.out.println("--- 示例1: 继承Thread ---");
        new MyThread().start();

        System.out.println("\n--- 示例2: 实现Runnable ---");
        new Thread(new MyRunnable("Runnable-1")).start();
        new Thread(new MyRunnable("Runnable-2")).start();

        System.out.println("\n--- 示例3: 实现Callable ---");
        FutureTask<Integer> task = new FutureTask<>(new MyCallable(1));
        new Thread(task).start();
        try { System.out.println("返回结果: " + task.get()); } catch (Exception e) { e.printStackTrace(); }

        System.out.println("\n--- 示例4/5/6: 线程安全演示 ---");
        SynchronizedCounter syncCounter = new SynchronizedCounter();
        BlockCounter blockCounter = new BlockCounter();
        LockCounter lockCounter = new LockCounter();

        Runnable inc = () -> {
            for (int i = 0; i < 1000; i++) {
                syncCounter.increment();
                blockCounter.increment();
                lockCounter.increment();
            }
        };

        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(inc);
        t1.start(); t2.start(); t1.join(); t2.join();

        System.out.println("synchronized结果: " + syncCounter.getCount() + " (期望: 2000)");
        System.out.println("synchronized代码块结果: " + blockCounter.getCount() + " (期望: 2000)");
        System.out.println("ReentrantLock结果: " + lockCounter.getCount() + " (期望: 2000)");

        System.out.println("\n========== 演示结束 ==========");
    }
}

/*
使用说明：
1. 保存为 ThreadExamples.java
2. 编译：javac ThreadExamples.java -d .
3. 运行：java ThreadExamples
4. 每个示例独立可运行，可注释测试不同部分
*/