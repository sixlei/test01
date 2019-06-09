package com.hd.ThreadTest;

import sun.applet.Main;

/**
 * 不要将字符串常量作为锁的对象，因为两个相同的字符串常量在堆内存是同一块内存
 */
public class ThreadTest12 {
    String s1="hello";
    String s2="hello";
    void m1(){
        synchronized (s1){
            while (true){

            }
        }
    }
    void m2(){
        synchronized (s2){
            System.out.println("s2");
        }
    }

    public static void main(String[] args) {
        ThreadTest12 threadTest12 = new ThreadTest12();
        new Thread(()->{threadTest12.m1();}).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //m2线程不能获取到锁。
        new Thread(()->{threadTest12.m2();}).start();
    }
}
