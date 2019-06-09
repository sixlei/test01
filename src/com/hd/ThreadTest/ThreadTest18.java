package com.hd.ThreadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReetranLock可以调用lockInterruptibly方法，可以对线程的interrupt方法做出响应
 */
public class ThreadTest18 {
    ReentrantLock lock =new ReentrantLock();
    void m1(){
        try {
            lock.lock();
            System.out.println("m1  start");
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            System.out.println("m1 stop");

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    void m2(){
        boolean flag=false;
        try {
            lock.lockInterruptibly();


        }catch (Exception e){

        }finally {

        }
    }

    public static void main(String[] args) {
        ThreadTest18 threadTest18 = new ThreadTest18();
        new Thread(()->{threadTest18.m1();}).start();
        Thread t2=new Thread(()->{threadTest18.m2();});
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();


    }
}
