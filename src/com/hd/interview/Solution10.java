package com.hd.interview;

/**
 * 判断是否是回文数
 */
public class Solution10 {
    public static boolean isPalindrome(int x){
//        if (x<0){
////            return false;
////        }
////        int d=1;
////        //得到最高位的运算级
////        while (x/d>=10) d*=10;
////        while (x>0){
////            int left=x%10;
////            int right=x/d;
////            if (left!=right){
////                return false;
////            }
////            x=x%d;
////            x/=10;
////            d/=100;
////        }
////
////        return true;


        if (x<0||(x%10==0&&x!=0)){
            return false;
        }
        int d=0;
        while (x>d){
            d=d*10+x%10;
            x/=10;
        }
        return x==d||x==d/10;
    }

    public static void main(String[] args) {
        int x=250;
        int d=1;
        System.out.println(isPalindrome(1012));
    }
}
