package com.hd.ThreadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用reentranlock替代synchornized
 *
 */
public class ThreadTest16 {
    ReentrantLock lock=new ReentrantLock();
    public void m(){
        try {
            lock.lock();
            for (int i=0;i<10;i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1   running");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            //一定要记得释放掉锁
            lock.unlock();
        }

    }
    public void m2(){
        try {
            lock.lock();
            System.out.println("m2   start");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadTest16 threadTest16 = new ThreadTest16();
        new Thread(()->{threadTest16.m();}).start();
        new Thread(()->{threadTest16.m2();}).start();
    }
}
