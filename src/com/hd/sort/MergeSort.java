package com.hd.sort;

/**
 * 时间复杂度O(nlog(n))
 * 空间复杂度O(n)
 * 稳定性：稳定
 */
public class MergeSort {
    public static void merge(int[] numbers,int start,int end,int mid){
        int[] temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int index=0;
        while (i<=mid&&j<=end){
            if (numbers[i]<=numbers[j]){
                temp[index++]=numbers[i++];
            }else{
                temp[index++]=numbers[j++];
            }
        }
        while (i<=mid){
            temp[index++]=numbers[i++];
        }
        while (j<=end){
            temp[index++]=numbers[j++];
        }
        for(int k=0;k<temp.length;k++){
            numbers[start+k]=temp[k];
        }
    }
    public static void sort(int[] numbers,int start,int end){
        if (start>=end){
            return;
        }
        int mid=(start+end)/2;
        sort(numbers,start,mid);
        sort(numbers,mid+1,end);
        merge(numbers,start,end,mid);

    }

    public static void main(String[] args) {
        int[] numbers={2,4,5,6,8,8,2,3,4,7,7};
        sort(numbers,0,numbers.length-1);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
