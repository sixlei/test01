package com.hd.ThreadTest;

/**
 * 线程运行过程中，如果抛出异常，将会立即释放当前获取的锁，其他线程将会处理运行到一半的数据。
 */
public class ThreadTest7 {
    int count=0;
    public synchronized void m(){
        while (true){
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+count);
            if (count==5){
                //直接抛出这个异常的时候，线程将运行结束，释放当前获取到的锁，其他线程获取到的count为5，
//                throw new Exception();
                //对异常进行处理后，线程将不会执行结束而释放锁。
                try {
                    throw new Exception();
                } catch (Exception e) {

                }
            }

        }
    }

    public static void main(String[] args) {
        ThreadTest7 threadTest = new ThreadTest7();
        new Thread(()->{
            threadTest.m();
        },"t1").start();
        new Thread(()->{
            threadTest.m();
        },"t2").start();
    }
}
