package com.hd.ThreadTest;

public class ThreadTest11 {
    Object o=new Object();
    void m(){
        synchronized (o){
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
    public static void main(String[] args) {
        ThreadTest11 threadTest11 = new ThreadTest11();
        new Thread(()->{threadTest11.m();}).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        //被锁住的对象已经发生改变。其实锁住的是堆内存中的对象的内存。
        threadTest11.o=new Object();
        new Thread(()->{threadTest11.m();}).start();
    }

}

