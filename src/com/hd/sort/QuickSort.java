package com.hd.sort;

/**
 * 快速排序
 * 时间复杂度O(nlog(n))
 * 空间复杂度O(1)
 * 稳定性：不稳定
 */

public class QuickSort {
    public static void quickSort(int[] numbers,int start,int end){
        if (start>=end){
            return;
        }
        int base=numbers[start];
        int i=start;
        int j=end;
        while (i!=j){
            while (numbers[j]>=base&&j>i){
                j--;
            }
            while (numbers[i]<=base&&i<j){
                i++;
            }
            if (i<j){
                int temp=numbers[i];
                numbers[i]=numbers[j];
                numbers[j]=temp;
            }
        }
        int temp=numbers[start];
        numbers[start]=numbers[i];
        numbers[i]=temp;
        quickSort(numbers,start,i-1);
        quickSort(numbers,i+1,end);
    }

    public static void main(String[] args) {
        int[] numbers={2,5,7,8,9,2,3,6,7};
        quickSort(numbers,0,numbers.length-1);
        for (int number : numbers) {
            System.out.println(number);

        }

    }
}
