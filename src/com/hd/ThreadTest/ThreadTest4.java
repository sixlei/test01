package com.hd.ThreadTest;

/**
 * 对业务的写加锁，读不加锁，可能造成脏读数据
 * 最简单的解决办法就是对读操作加上锁
 */
public class ThreadTest4 {
    private double balance;
    public synchronized void set(double balance){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;

    }
    public synchronized void get(){
        System.out.println(balance);
    }

    public static void main(String[] args) {
        ThreadTest4 threadTest4 = new ThreadTest4();
        new Thread(()->{threadTest4.set(100.0);}).start();
        new Thread(()->{threadTest4.get();}).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{threadTest4.get();}).start();
    }
}
