package com.hd.ThreadTest;

import java.util.LinkedList;

/**
 * 写一个固定容量的同步容器，拥有get和put方法，以及getCount方法
 */
public class ThreadTest20 {
    private LinkedList<Integer> linkedList=new LinkedList<>();
    final private int Max=10;
    private volatile int count=0;
    public synchronized void put(Integer integer){
        while (linkedList.size()==Max){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        linkedList.add(integer);
        count++;
        this.notifyAll();
    }
    public synchronized void get(){
        while (linkedList.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer integer = linkedList.removeFirst();
        System.out.println(integer);
        count--;
        this.notifyAll();

    }

    public static void main(String[] args) {
        ThreadTest20 threadTest20 = new ThreadTest20();
        for(int i=0;i<5;i++){
            new Thread(()->{
                for(int j=0;j<10;j++){
                threadTest20.get();
                }
            }).start();
        }

        for (int i=0;i<3;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                    threadTest20.put(new Integer(j));
                }
            }).start();
        }

    }
}
