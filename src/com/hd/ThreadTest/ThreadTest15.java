package com.hd.ThreadTest;
/**
 *  曾经的面试题：（淘宝？）
 *  实现一个容器，提供两个方法，add，size
 *  写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *  这个给出的是使用volatile
 *  给lists添加volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，该怎么做呢？
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadTest15 {
    volatile List<Integer> list=new ArrayList<>();
    public Integer getSize(){
        return list.size();
    }
    public void add(Integer integer){
        list.add(integer);
    }

    public static void main(String[] args) {
        ThreadTest15 threadTest13 = new ThreadTest15();
        //新建门闩，设置数量为1
        CountDownLatch lanch = new CountDownLatch(1);
        new Thread(
                new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1  runing");
                for(int i=0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    threadTest13.add(i);
                    if (threadTest13.getSize()==5){
                        //当size为5的时候，让门闩数量减1.
                        lanch.countDown();
                    }
                }
                System.out.println("thread1   end");
            }
        }).start();

        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    if (threadTest13.getSize()!=5){
                        try {
                            //加入门闩，当门闩数量为0的时候，才能继续执行
                            lanch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread2 end");
                }
            },"thread2"
        ).start();
    }

}
