package com.hd.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用reentranlock可以指定公平锁
 */
public class ThreadTest19 {
    ReentrantLock lock=new ReentrantLock(true);
    public void m1(){
        for(int i=0;i<100;i++){
            lock.lock();
            System.out.println(Thread.currentThread().getName()+":"+i);
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadTest19 threadTest19 = new ThreadTest19();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        threadTest19.m1();
                    }
                },"thread1"
        ).start();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        threadTest19.m1();
                    }
                },"thread2"
        ).start();
    }
}
