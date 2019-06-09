package com.hd.ThreadTest;
//懒汉式
//public class Singleton {
//    //使用懒汉式。真正用到的时候在进行初始化
//    private static Singleton singleton;
//    //构造方法私有化
//    private Singleton(){
//
//    }
//    public static Singleton getInstance(){
//        if (singleton==null){
//            synchronized (Singleton.class){
//                if(singleton==null){
//                    singleton=new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//
//}

//饿汉式
//public class Singleton{
//    //加载类的时候就进行初始化
//    private static Singleton singleton=new Singleton();
//    private Singleton(){
//
//    }
//    public static Singleton getInstance(){
//        return singleton;
//    }
//}


/**
 *  线程安全的单例模式
 *  既不用加锁，也能实现懒加载
 *
 *
 *
 * **/
//public class Singleton{
//    //构造方法私有化
//    private Singleton(){
//
//    }
//
//    //静态内部类中实例化引用
//    private static class Inner{
//        private static Singleton singleton=new Singleton();
//    }
//
//    //getInstance方法中将Inner中的singleton取出
//    private static Singleton getInstance(){
//        return Inner.singleton;
//    }
//
//    public static void main(String[] args) {
//        for (int i=0;i<100;i++){
//            new Thread(()->{
//                System.out.println(Singleton.getInstance());
//            }).start();
//        }
//    }
//
//
//}


