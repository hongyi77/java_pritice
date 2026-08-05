package com.thunder程.thirdthunder;

import java.util.concurrent.Callable;
//第三种线程方式，与runnable不同的是该线程会返回结果
public class thirdwork implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <=100 ; i++) {
            sum = sum +i;
        }
        return sum;
    }
}
