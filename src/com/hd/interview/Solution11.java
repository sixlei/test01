package com.hd.interview;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;

/**
 * 判断链表是不是回文
 * 思路：先找到链表中点，再从中点开始，对后面的部分进行逆序，
 * 使用快慢链表的方式找到中点
 */
public class Solution11 {
    static  class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    public static boolean isPalindrome(ListNode head){
        if (head==null){
            return false;
        }
       ListNode fast=head;
       ListNode slow=head.next;
       while (fast.next!=null&&fast.next.next!=null){
           fast=fast.next.next;
           slow=slow.next;
       }

       slow = reverse(slow);
       while (slow!=null){
           System.out.println(head.val);
           System.out.println(slow.val);
           if (head.val!=slow.val){
               return false;
           }
           head=head.next;
           slow=slow.next;
       }
        return true;
    }

    public static ListNode reverse(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(3);
        ListNode l5=new ListNode(2);
        ListNode l6=new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        boolean b = isPalindrome(l1);
        System.out.println(b);

    }
}
