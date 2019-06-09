package com.hd.threadcontainer;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制容器
 * 多线程环境下，写的效率很低，读的效率很高
 * 适合写少读多的环境
 */
public class CopyOnWriteList {
    public static void main(String[] args) {
        List<String> list=new CopyOnWriteArrayList<>();   //效率低
//        List<String> list=new Vector<>();
//        List<String> list=new ArrayList<>();   //线程不安全
        Thread[] threads=new Thread[100];

        Random r=new Random();
        for(int i=0;i<100;i++){

            threads[i]=new Thread(()->{
                for(int j=0;j<1000;j++){

                    list.add("a"+r.nextInt(10000));
                }
            });
        }
        long s1=System.currentTimeMillis();
        Arrays.asList(threads).forEach(a->a.start());
        Arrays.asList(threads).forEach(a->{
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2=System.currentTimeMillis();
        System.out.println(list.size());
        System.out.println(s2-s1);
    }
}
