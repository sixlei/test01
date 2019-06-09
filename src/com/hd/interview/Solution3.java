package com.hd.interview;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode l3=new ListNode(0);
        ListNode cur=l3;
        int k=0;
        while (l1!=null||l2!=null){
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            int sum=x+y+k;
            k=sum/10;
            l3.next=new ListNode(sum%10);
            l3=l3.next;
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }

        }
        if (k!=0){
            l3.next=new ListNode(k);
        }
        l3=cur.next;
        return l3;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(9);
        l2.next.next=new ListNode(9);
        l2.next.next.next=new ListNode(9);
        l2.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next=new ListNode(9);
        ListNode node = addTwoNumbers(l1, l2);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }

    }
}
