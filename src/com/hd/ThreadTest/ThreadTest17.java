package com.hd.ThreadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用reentranlock可以尝试获取锁，trylock，可以在里面加时间，在指定时间内无法获取，线程可决定是否等待
 *
 */
public class ThreadTest17 {
    ReentrantLock lock=new ReentrantLock();
    void m1(){
        try {
            lock.lock();
            for(int i=0;i<10;i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1:"+i);
            }

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    void m2(){
        boolean tryLock =false;
        try {
            tryLock = lock.tryLock(5,TimeUnit.SECONDS);
            if (tryLock){
                System.out.println("m2 get");
            }
            System.out.println("m2 trup");
        }catch (Exception e){

        }finally {
            if (tryLock)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadTest17 threadTest17 = new ThreadTest17();
        new Thread(()->{threadTest17.m1();}).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{threadTest17.m2();}).start();
    }
}
