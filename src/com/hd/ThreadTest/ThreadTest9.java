package com.hd.ThreadTest;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile能保证可见性，不能保证原子性，也就是说不能替代synchronized
 *
 */
public class ThreadTest9 {
        //只使用volatile不能保证多个线程对数据操作的原子性
        /*volatile*/ int count = 0;
        //使用synchornized可以保证操作的原子性。
        synchronized void m() {
            for(int i=0; i<10000; i++) count++;
        }

        public static void main(String[] args) {
            ThreadTest9 t = new ThreadTest9();

            List<Thread> threads = new ArrayList<Thread>();

            for(int i=0; i<10; i++) {
                threads.add(new Thread(t::m, "thread-"+i));
            }

            threads.forEach((o)->o.start());

            threads.forEach((o)->{
                try {
                    o.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println(t.count);


        }



}
