package com.thunder程.thirdthunder;

import java.util.concurrent.Callable;

public class fifthwork implements Callable {
    int id;

    public fifthwork(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("线程id"+id+"开始计算");
        Thread.sleep(2000);//停留2秒
        return id*100;
    }
}
