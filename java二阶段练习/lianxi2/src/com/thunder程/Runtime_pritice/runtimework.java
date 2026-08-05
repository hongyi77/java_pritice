package com.thunder程.Runtime_pritice;
//当你想继承别的类时，可以使用专属线程的接口Runnable
public class runtimework implements Runnable{
    //注意此结果不会返回值 此线程不能直接调用get方法
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            Thread thread = Thread.currentThread();//获取当前线程的对象
            System.out.println(thread.getName()+"hello world");
        }
    }
}
