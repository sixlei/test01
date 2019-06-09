package com.hd.ThreadTest;

/**
 * 继承中发生的情形，子类调用父类的方法
 */
public class ThreadTest6 {
    public synchronized void m(){
        System.out.println("m   start");

    }

    public static void main(String[] args) {
        TT tt = new TT();
        new Thread(()->{tt.m();}).start();

    }


}
class TT extends ThreadTest6{
    public synchronized void m(){
        System.out.println("clild m start");
        super.m();

    }
}
