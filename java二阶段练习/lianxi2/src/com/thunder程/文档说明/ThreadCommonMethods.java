package com.thunder程.文档说明;

/**
 * Thread 常见成员方法 - 知识点总结文档
 * 来源：黑马程序员
 * 整理日期：2026-08-10
 *
 * 本文档将方法整理为可运行的代码示例，每个方法都有对应的测试类
 * 方便批注和学习
 */
public class ThreadCommonMethods {

    // ================================================================
    // 一、基础信息方法
    // ================================================================

    /**
     * getName() - 返回线程名称
     * 用法：String name = thread.getName();
     */
    static void demo_getName() {
        Thread t1 = new Thread(() -> {
            System.out.println("当前线程名: " + Thread.currentThread().getName());
        });
        t1.setName("我的线程A");
        t1.start();
        System.out.println("主线程名: " + Thread.currentThread().getName());
        // 默认线程名格式：Thread-0, Thread-1, ...
    }

    /**
     * setName(String name) - 设置线程名称
     * 用法：thread.setName("自定义名称");
     */
    static void demo_setName() {
        Thread t = new Thread(() -> {
            System.out.println("我现在的名字是: " + Thread.currentThread().getName());
        });
        t.setName("我是新名字");
        t.start();
    }

    // ================================================================
    // 二、静态方法 - 线程控制
    // ================================================================

    /**
     * currentThread() - 获取当前执行线程的对象
     * 用法：Thread current = Thread.currentThread();
     * 说明：这是一个静态方法，返回的是"正在执行这段代码的线程"
     */
    static void demo_currentThread() {
        Thread t = new Thread(() -> {
            Thread current = Thread.currentThread();
            System.out.println("当前线程对象: " + current);
            System.out.println("当前线程名: " + current.getName());
            System.out.println("当前线程是否存活: " + current.isAlive());
        });
        t.setName("测试线程");
        t.start();
    }

    /**
     * sleep(long millis) - 让当前线程休眠指定毫秒数 ⭐⭐⭐ 重点
     * 用法：Thread.sleep(1000); // 休眠1秒
     * 重要说明：
     *   1. 休眠期间持有锁（不会释放同步锁）
     *   2. 会抛出 InterruptedException，必须处理
     *   3. 休眠结束后进入就绪状态，不是直接运行
     *   4. 是静态方法，操作的是当前正在执行的线程
     */
    static void demo_sleep() {
        try {
            System.out.println("休眠前...");
            Thread.sleep(1000); // 暂停1秒
            System.out.println("休眠结束");
        } catch (InterruptedException e) {
            System.out.println("线程被中断");
            e.printStackTrace();
        }
    }

    /**
     * yield() - 礼让线程，让出CPU
     * 用法：Thread.yield();
     * 重要说明：
     *   1. 当前线程从运行态 → 就绪态
     *   2. 不释放锁
     *   3. 只是"提示"调度器，不保证一定让出
     *   4. 同优先级或更高优先级的线程可能接着执行
     */
    static void demo_yield() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                if (i == 2) {
                    Thread.yield(); // 在第3次循环时礼让
                }
            }
        });
        t.setName("礼让线程");
        t.start();
    }

    /**
     * join() - 插队/等待，当前线程等待指定线程执行完毕再继续
     * 用法：thread.join(); 或 thread.join(1000); // 最多等1秒
     * 重要说明：
     *   1. 会抛出 InterruptedException
     *   2. 常用于等待某个线程完成后再执行后续操作
     *   3. 是实例方法，调用的是"另一个线程的join()方法"
     */
    static void demo_join() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("子线程: " + i);
            }
        });
        t1.setName("子线程");

        t1.start();
        // 主线程等待 t1 执行完毕再继续
        t1.join();
        System.out.println("子线程已执行完毕，主线程继续");
    }

    // ================================================================
    // 三、优先级相关
    // ================================================================

    /**
     * setPriority(int priority) - 设置线程优先级
     * 用法：thread.setPriority(Thread.MAX_PRIORITY); // 10
     * 重要说明：
     *   1. 优先级范围：1 (MIN) ~ 10 (MAX)，默认 5 (NORM)
     *   2. 高优先级只是"概率上"更容易被调度，不保证先执行
     *   3. 优先级是"提示"，不是"强制"
     */
    static void demo_setPriority() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("高优先级线程: " + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("低优先级线程: " + i);
            }
        });
        t1.setName("高优先级");
        t2.setName("低优先级");
        t1.setPriority(Thread.MAX_PRIORITY);   // 10
        t2.setPriority(Thread.MIN_PRIORITY);   // 1
        t1.start();
        t2.start();
    }

    /**
     * getPriority() - 获取线程优先级
     * 用法：int priority = thread.getPriority();
     */
    static void demo_getPriority() {
        Thread t = new Thread(() -> {});
        t.setName("普通线程");
        System.out.println(t.getName() + " 的优先级: " + t.getPriority());
        // 默认优先级是 5 (NORM_PRIORITY)
    }

    // ================================================================
    // 四、守护线程
    // ================================================================

    /**
     * setDaemon(boolean on) - 设置为守护线程
     * 用法：thread.setDaemon(true); // 必须在 start() 之前调用！
     * 重要说明：
     *   1. 守护线程随主线程结束而结束
     *   2. 必须在 start() 之前设置，否则抛 IllegalThreadStateException
     *   3. 典型例子：垃圾回收线程(GC)就是守护线程
     */
    static void demo_setDaemon() {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("守护线程在运行...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        daemonThread.setName("守护线程");
        daemonThread.setDaemon(true); // ⚠️ 必须在 start() 之前
        daemonThread.start();

        // 主线程休眠3秒后结束，守护线程随之结束
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束，守护线程也跟着结束了");
    }

    // ================================================================
    // 五、其他常用方法
    // ================================================================

    /**
     * isAlive() - 判断线程是否存活
     * 用法：boolean alive = thread.isAlive();
     * 说明：线程创建后未start或已结束后返回false，start后到结束前返回true
     */
    static void demo_isAlive() {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setName("测试存活");
        System.out.println("start前: " + t.isAlive()); // false
        t.start();
        System.out.println("start后: " + t.isAlive()); // true
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束后: " + t.isAlive()); // false
    }

    /**
     * interrupt() - 中断线程
     * 用法：thread.interrupt();
     * 说明：
     *   1. 设置线程的中断标志位为true
     *   2. 如果线程在sleep/wait/join阻塞中，会抛出InterruptedException
     *   3. 推荐使用中断机制而非Thread.stop()（stop已废弃）
     */
    static void demo_interrupt() {
        Thread t = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始休眠...");
                Thread.sleep(5000); // 休眠5秒
                System.out.println(Thread.currentThread().getName() + " 休眠结束");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断了！");
                // 这里处理中断
            }
        });
        t.setName("可中断线程");
        t.start();

        // 主线程休眠1秒后中断子线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println("主线程已发送中断信号");
    }

    /**
     * getId() - 获取线程的唯一ID
     * 用法：long id = thread.getId();
     * 说明：线程创建后ID固定不变，不同线程ID不同
     */
    static void demo_getId() {
        Thread t = new Thread(() -> {});
        t.setName("ID测试");
        t.start();
        System.out.println(t.getName() + " 的ID: " + t.getId());
    }

    // ================================================================
    // 六、方法对比总结表
    // ================================================================
    /*
     * 方法名                  | 类型     | 是否抛异常 | 作用
     * ----------------------------------------------------------
     * getName()              | 实例方法 | 否        | 返回线程名
     * setName(String)        | 实例方法 | 否        | 设置线程名
     * currentThread()        | 静态方法 | 否        | 获取当前执行线程对象
     * sleep(long)            | 静态方法 | 是        | 线程休眠指定毫秒
     * yield()                | 静态方法 | 否        | 礼让线程，让出CPU
     * join()                 | 实例方法 | 是        | 等待线程执行完毕
     * setPriority(int)       | 实例方法 | 否        | 设置优先级(1-10)
     * getPriority()          | 实例方法 | 否        | 获取优先级
     * setDaemon(boolean)     | 实例方法 | 否        | 设置守护线程（须在start前）
     * isAlive()              | 实例方法 | 否        | 判断线程是否存活
     * interrupt()            | 实例方法 | 否        | 中断线程（设中断标志）
     * getId()                | 实例方法 | 否        | 获取线程唯一ID
     *
     * 静态方法：不需要对象，直接用 Thread.方法名() 调用
     * 实例方法：需要先创建Thread对象，用 对象.方法名() 调用
     */

    /**
     * 主方法 - 测试所有方法
     * 注释掉不需要测试的部分，取消注释需要测试的部分
     */
    public static void main(String[] args) {
        System.out.println("========== getName/setName ==========");
        demo_getName();
        demo_setName();

        System.out.println("\n========== currentThread ==========");
        demo_currentThread();

        System.out.println("\n========== sleep ==========");
        demo_sleep();

        System.out.println("\n========== yield ==========");
        demo_yield();

        System.out.println("\n========== join ==========");
        try {
            demo_join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n========== setPriority ==========");
        demo_setPriority();
        demo_getPriority();

        System.out.println("\n========== setDaemon ==========");
        demo_setDaemon();

        System.out.println("\n========== isAlive ==========");
        demo_isAlive();

        System.out.println("\n========== interrupt ==========");
        demo_interrupt();

        System.out.println("\n========== getId ==========");
        demo_getId();
    }
}
