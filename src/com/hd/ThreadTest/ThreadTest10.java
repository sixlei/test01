package com.hd.ThreadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决上一题中对count++操作只能使用synchornized，
 * 使用AtomXXX类可以保证原子性
 * AtomicXXX类本身方法都是原子性的
 *
 */
public class ThreadTest10 {
    AtomicInteger count=new AtomicInteger(0);
    void m(){
        for(int i=0;i<1000;i++){
            count.incrementAndGet();   //count++
        }
    }

    public static void main(String[] args) {
        ThreadTest10 t = new ThreadTest10();
        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }

}
