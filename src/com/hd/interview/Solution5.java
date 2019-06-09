package com.hd.interview;

public class Solution5 {
    public static double findMedianSorted(int[] A,int[] B){
        int m=A.length;
        int n=B.length;
        if (m>n){
            //交换数组
            int[] temp=A;
            A=B;
            B=temp;
            //交换m，n
            int tmp=m;
            m=n;
            n=tmp;
        }
        int imin=0;
        int imax=m;
        int halfLen=(m+n+1)/2;
        while (imin<=imax){
            int i=(imax+imin)/2;
            int j=halfLen-i;
            //描述三种情况
            if (i<imax&&B[j-1]>A[i]){
                imin=i+1;
            }else if (i>imin&&A[i-1]>B[j]){
                imax=i-1;
            }
            else {
                int maxLeft=0;
                if (i==0){
                    maxLeft=B[j-1];
                }else if (j==0){
                    maxLeft=A[i-1];
                }else {
                    maxLeft=Math.max(A[i-1],B[j-1]);
                }

                if ((m+n)%2==1){
                    return maxLeft;
                }

                int minRight=0;
                if (i==m){
                    minRight=B[j];
                }else if (j==n){
                    minRight=A[i];
                }else {
                    minRight=Math.min(A[i],B[j]);
                }
                return (minRight+maxLeft)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] A={2,3,4,5,6,7,9};
        int[] B={1,6,10,14};
        double sorted = findMedianSorted(A, B);
        System.out.println(sorted);
    }
}
