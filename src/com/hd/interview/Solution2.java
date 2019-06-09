package com.hd.interview;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Solution2 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if (l1==null&&l2==null){
            return null;
        }
        BigInteger s1=BigInteger.valueOf(0);
        BigInteger s2=BigInteger.valueOf(0);
        BigInteger k=BigInteger.valueOf(1);
        while (l1!=null){
            s1=s1.add(k.multiply(BigInteger.valueOf(l1.val)));
            k=k.multiply(BigInteger.valueOf(10));
            l1=l1.next;
        }
        k=BigInteger.valueOf(1);
        while(l2!=null){
            s2=s2.add(k.multiply(BigInteger.valueOf(l2.val)));
            k=k.multiply(BigInteger.valueOf(10));
            l2=l2.next;
        }
        BigInteger s3=s1.add(s2);
        System.out.println(s3);
        if (!s3.equals(BigInteger.valueOf(0))){
            ListNode l3=null;
            List<ListNode> list=new ArrayList<>();
            while (!s3.equals(BigInteger.valueOf(0))){
                BigInteger s4=s3.divide(BigInteger.valueOf(10));
                list.add(new ListNode(s4.bitCount()));
                s3.divide(BigInteger.valueOf(10));
            }
            l3=list.get(0);
            for(int i=0;i<list.size()-1;i++){
                list.get(i).next=list.get(i+1);
            }
            return l3;
        }else {
            return new ListNode(0);
        }

    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(9);
        l2.next.next=new ListNode(9);
        l2.next.next.next=new ListNode(9);
        l2.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next=new ListNode(9);
        System.out.println(Double.MAX_VALUE);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
}
