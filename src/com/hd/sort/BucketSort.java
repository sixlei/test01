package com.hd.sort;

/**
 * 堆排序
 * 时间复杂度O(nlog(n))
 * 稳定性：不稳定
 */
public class BucketSort {
    public static void adjustBucket(int[] numbers,int i,int length){
        int base=numbers[i];
        for(int j=2*i+1;j<length;j=j*2+1){
            if (numbers[j+1]>numbers[j]&&j+1<length){
                j=j+1;
            }
            if (numbers[j]>base){
                numbers[i]=numbers[j];
                i=j;
            }else{
                break;
            }
        }
        numbers[i]=base;
    }
    public static void swap(int[] numbers,int a,int b){
        int temp=numbers[a];
        numbers[a]=numbers[b];
        numbers[b]=temp;
    }
    public static void sort(int[] numbers){
        int length=numbers.length;
        for(int i=length/2;i>=0;i--){
            adjustBucket(numbers,i,length);
        }
        for(int i=length-1;i>=0;i--){
            swap(numbers,0,i);
            adjustBucket(numbers,0,i);
        }
    }

    public static void main(String[] args) {
        int[] numbers={2,5,7,8,4,2,3,6,5,8,4,2,1};
        sort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
