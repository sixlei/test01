package com.hd.Test;

/**
 * 对象类型和基本数据类型比较的时候，对象类型经过Integer.intvalue()的自动拆箱操作。
 * Integer i=10这句话实际上经过了自动装箱，也就相当于是Integer i=Integer.valueOf(10)
 * Integer.valueOf()自动装箱。当里面的数值为-128-127时候，返回的是缓存的Integer对象，否则返回的是new 的Integer对象。
 * 所以Integer i=1;和Integer j=Integer.valueOf(1),都是缓存的Integer对象，是相等的，
 * Integer i=130;和Integer j=Integer.valueOf(130)，都是new的新对象，返回false
 * 两个对象比较，会比较对象地址。
 *
 */

/**
 * 数组在内存中是一块连续的内存，插入，删除数据的时候需要移动内存
 * 链表的内存不一定要是连续的
 */
public class Demo01 {
    public static void main(String[] args) {
        //System.out.println("this is my first test");
        Integer i=130;
        int a=1;
        Integer j=new Integer(130);
        Integer q=Integer.valueOf(130);
        //System.out.println(i==q);



        String aa="a";
        String bb="a";
        String c="a"+"b";
        System.out.println(c);
        String cc=new String("a");
        System.out.println(aa==cc);

    }
}

/**
 * 单例模式
 */
//饿汉模式
class Singleton{
    private static Singleton singleton=new Singleton();
    private Singleton(){}
    public static  Singleton getInstance(){
        return  singleton;
    }


}

/*
    懒汉模式
 */
class Single{
    private static  Single single;
    private  Single(){}
    public static Single getInstance(){
        if (single==null){
           synchronized (Single.class){
               single=new Single();
           }
            single=new Single();
        }
        return  single;
    }
}