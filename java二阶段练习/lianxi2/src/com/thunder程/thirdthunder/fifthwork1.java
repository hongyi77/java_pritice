package com.thunder程.thirdthunder;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class fifthwork1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new fifthwork(1));
        FutureTask<Integer> futureTask1 = new FutureTask<>(new fifthwork(2));
        Thread thread = new Thread(futureTask);
        Thread thread1 = new Thread(futureTask1);
        thread.start();
        thread1.start();
        Integer i = futureTask.get();
        Integer i1 = futureTask1.get();
        System.out.println(i);
        System.out.println(i1);
    }
}
