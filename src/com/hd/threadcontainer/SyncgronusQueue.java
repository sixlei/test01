package com.hd.threadcontainer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SyncgronusQueue {   //容量为0，不能使用add 是一种特殊的tarnasferqueue，put方法内部是tansfer，直接交给消费者。进入阻塞。
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs=new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa");
//        strs.add("aaa");

    }
}
