package com.hd.threadcontainer;

import java.util.*;

public class SynchronizedList {
    public static void main(String[] args) {
        List<String> str=new ArrayList<>();
        /**
         * 从执行时间大致看出synchronizedList和Vector效率大致相同
         */
        List<String> list = Collections.synchronizedList(str);
//        List<String> list=new Vector<>();
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
