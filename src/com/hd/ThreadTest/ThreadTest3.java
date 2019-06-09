package com.hd.ThreadTest;

/**
 * 同步方法和非同步方法是否能同时调用
 * 可以
 */
public class ThreadTest3 {
    public synchronized void m1(){
        System.out.println("m1  start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1   end");
    }
    public void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2  done");
    }

    public static void main(String[] args) {
        ThreadTest3 threadTest3 = new ThreadTest3();
        new Thread(()->{
            threadTest3.m1();
        }).start();
        new Thread(()->{threadTest3.m2();}).start();
    }
}
