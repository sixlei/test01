package com.hd.threadcontainer;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞容器
 * 能够自己实现阻塞
 */
public class BlockingQueue {
    //linkedblockingqueue无界的
    static java.util.concurrent.BlockingQueue<String> queue=new LinkedBlockingQueue<>();
    static Random r=new Random();
    public static void main(String[] args) {
        new Thread(()->{
            for(int i=0;i<100;i++){
                try {
                    queue.put("a"+i);  //put方法如果容器满了，就会陷入阻塞
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread1").start();

        for(int i=0;i<5;i++){
            new Thread(()->{
                try {
                    for(;;) {
                        //take方法如果容器空了就会陷入阻塞，等待生产者生产
                        System.out.println(Thread.currentThread().getName() + "take---" + queue.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
