package com.thunder程.thunder_instance1;

/**
 * yield() 演示 - 礼让线程
 * 理解yield的关键：它只是"提示"，不保证一定让出
 */
public class YieldDemo {

    /**
     * 演示1：yield的基本效果
     */
    public static void demo1() {
        Thread high = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                // i==3时礼让，让其他线程有机会先执行
                if (i == 3) {
                    Thread.yield();
                    System.out.println("【礼让】其他线程，你来！");
                }
                System.out.println("高优先级线程: " + i);
            }
        });
        high.setName("高优先级");// 为了让yield容易触发，我将他们优先级统一成了一样 就是24行的代码
        high.setPriority(Thread.NORM_PRIORITY); // 设为最高优先级

        Thread low = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("低优先级线程: " + i);
            }
        });
        low.setName("低优先级");
        low.setPriority(Thread.NORM_PRIORITY); // 设为最低优先级

        high.start();
        low.start();
    }

    /**
     * 演示2：yield vs sleep 的区别
     */
    public static void demo2() {
        System.out.println("=== yield示例 ===");
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("线程A: " + i);
                if (i == 2) {
                    Thread.yield(); // 礼让，不释放任何锁
                    System.out.println("cpu爸爸，让别的线程先走吧");
                }
            }
        });
        t1.setName("线程A");

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("线程B: " + i);
            }
        });
        t2.setName("线程B");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        demo1();
        try { Thread.sleep(1000); } catch (Exception e) {}
        System.out.println("---------");
        demo2();
        try { Thread.sleep(1000); } catch (Exception e) {}
        System.out.println("----------");
    }
}
