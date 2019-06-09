package com.hd.threadcontainer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 实现定时任务
 * 队列中按照时间进行排序，get的时候按照时间顺序进行取出
 */
public class DelayQueue {
    static BlockingQueue<MyTask> queue=new java.util.concurrent.DelayQueue<>();

    static class MyTask implements Delayed{

        long runtime;
        public MyTask(Long runtime){
            this.runtime=runtime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runtime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);

//            return unit.convert(1000,TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS)<o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS)>o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return ""+runtime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask(now + 1000);
        MyTask t2 = new MyTask(now + 2000);
        MyTask t3 = new MyTask(now + 1500);
        MyTask t4 = new MyTask(now + 2500);
        MyTask t5 = new MyTask(now + 500);
        queue.put(t1);
        queue.put(t2);
        queue.put(t3);
        queue.put(t4);
        queue.put(t5);
        System.out.println(queue);
        for (int i=0;i<5;i++){
            System.out.println(queue.take());
        }


    }
}
