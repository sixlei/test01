package com.hd.ThreadTest;

import java.util.concurrent.TimeUnit;

/**
 * 使用ThreadLocal
 */
public class ThreadTest22 {
    static ThreadLocal<Person> threadLocal=new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person());
        }).start();
    }



}
