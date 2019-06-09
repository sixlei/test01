package com.hd.ThreadTest;

public class ThreadTest {
    private int count=1000;

    public synchronized void m() {
        for (int i=0;i<10;i++){
            System.out.println(count);
            count--;

        }

    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        for(int i=0;i<100;i++){
            new Thread(()->{
                threadTest.m();
            }).start();
        }

    }
}
