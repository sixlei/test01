package com.hd.threadcontainer;

import java.util.concurrent.LinkedTransferQueue;

/**
 * 多了一个transfer方法，当使用transfer方法时，会直接交给消费者，不经过队列
 */
public class TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs=new LinkedTransferQueue<>();
        //将消费者放在transfer之前，直接取到
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//这三个方法和之前相同
//        strs.add("aaa");
//        strs.put("aaa");
//        strs.transfer("aaa");
        strs.transfer("aaa");   //如果当前没有消费者，会陷入阻塞，消费者必须要启动在transfer之前，启动在之后的话会直接阻塞
//        new Thread(()->{
//            try {
//                System.out.println(strs.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

    }
}
