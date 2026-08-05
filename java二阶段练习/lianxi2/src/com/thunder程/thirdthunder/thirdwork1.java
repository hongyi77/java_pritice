package com.thunder程.thirdthunder;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

public class thirdwork1 {
    public static void main(String[] args) throws Exception {
        thirdwork th  =new thirdwork();
        FutureTask<Integer> futureTask = new FutureTask<>(th);
        //对线程结果进行管理
       Thread t1 = new Thread(futureTask);
       t1.start();
        Integer i = futureTask.get();
        System.out.println(i);
    }
}
