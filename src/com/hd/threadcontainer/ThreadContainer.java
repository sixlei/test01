package com.hd.threadcontainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreadContainer {
    static List<String> tickets=new LinkedList<>();
    static {
        for (int i=0;i<1000;i++){
            tickets.add("票编号："+i);
        }
    }



    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                while (true){
                    synchronized (ThreadContainer.class){
                        if (tickets.size()<=0){
                            break;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了"+"---"+tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
