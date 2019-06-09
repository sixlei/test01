package com.hd.threadcontainer;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 链表队列，无界
 */
public class ConCurrentLinkedQueue {
    public static void main(String[] args) {
        Queue<String> queue=new ConcurrentLinkedQueue<>();
        Deque<String> deque=new ConcurrentLinkedDeque<>(); //双向队列，可以从头或者尾部进行读取数据

        for(int i=0;i<10;i++){
            queue.offer("a"+i);

        }
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue.size());

    }
}
