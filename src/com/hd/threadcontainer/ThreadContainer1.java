package com.hd.threadcontainer;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadContainer1 {
    Queue<String> tickets=new ConcurrentLinkedQueue<>();
    void getTicket(){
        while (true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = tickets.poll();
            if (s==null){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"  "+s);
        }
    }

    public static void main(String[] args) {

        ThreadContainer1 container1 = new ThreadContainer1();
        Queue<String> tickets = container1.tickets;
        for(int i=0;i<1000;i++){
            tickets.add("票编号："+i);
        }
        for (int i=0;i<10;i++){
            new Thread(()->{
                container1.getTicket();
            }).start();
        }
    }

}
