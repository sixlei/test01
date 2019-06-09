package com.hd.ThreadTest;
/**
 * volatile关键字，使一个变量在多个线程中可见
 * A B线程用到同一个变量，java默认是A，B线程各从主内存中copy一份，对这个copy值进行操作
 * B对这个值进行修改并放回到主内存中，A未必知道已经修改
 * 使用volatile关键字，会让所有线程都会读到变量的修改值
 *
 * 注意，使用volatile关键字并不是让线程每次对数据操作时候都去读取一次，而是当这个数据发生修改的时候
 * 主内存会提醒其他线程来刷新该值。
 */

import java.util.concurrent.TimeUnit;

public class ThreadTest8 {
    /*volatile*/boolean running=true;
    void m(){
        System.out.println("m  start");
        while (running){
            System.out.println("m");
        }
        System.out.println("m   end");
    }
    void m2(){
        running=false;
    }

    public static void main(String[] args) {
        ThreadTest8 threadTest8 = new ThreadTest8();
        new Thread(()->{threadTest8.m();}).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadTest8.running=false;
    }
}
