package com.hd.ThreadTest;

public class ThreadTest2 implements Runnable {

    private int count = 10;

    public /*synchronized*/ void run() {

            count--;


        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        ThreadTest2 t = new ThreadTest2();
        for(int i=0; i<5; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }

}