package com.hd.interview;

public class Solution6 {
    public static String longestPalindrome(String s){
        if (s==null||s.length()==0){
            return "";
        }
        int len=s.length();
        int[][] dp=new int[len][len];
        int max=1;  //回文串长度
        int start=0;   //回文串起始位置
        for(int i=0;i<len;i++){
            dp[i][i]=1;
            if (i<len-1&&s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                start=i;
                max=2;
            }

        }
        for(int l=3;l<=len;l++){
            for(int i=0;i+l-1<len;i++){
                int j=i+l-1;
                if (s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]==1){
                    dp[i][j]=1;
                    max=l;
                    start=i;
                }
            }
        }
        return s.substring(start,start+max);
    }

    public static void main(String[] args) {
        String s="abcba";
        String s1 = longestPalindrome(s);
//        System.out.println(s.substring(0,3));
        System.out.println(s1);
    }
}
