package com.hd.ThreadTest;

/**
 * 一个同步方法可以调用另一个同步方法，就是说，一个线程已经获取到某个对象的锁，
 * 再次申请时仍然会获取到该对象的锁
 * 也就是说，synchorized是可重入锁
 */
public class ThreadTest5 {
    public synchronized void m1(){
        System.out.println("m1  start");
        //如果不是可重入锁，此处m2申请已经获取到的锁，但是m1没执行完，不能释放锁，所以将会陷入死循环。
        m2();
    }
    public synchronized void m2(){
        System.out.println("m2   start");
    }

    public static void main(String[] args) {
        ThreadTest5 threadTest5 = new ThreadTest5();
        new Thread(()->{threadTest5.m1();}).start();
    }
}
