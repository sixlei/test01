package com.hd.sort;

/**
 * 冒泡排序
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 稳定性：稳定
 */
public class BubbleSort {
    public static void bubbleSort(int[] numbers){
        for(int i=1;i<numbers.length;i++){
            for(int j=0;j<numbers.length-i;j++){
                if (numbers[j+1]>numbers[j]){
                    numbers[j+1]=numbers[j+1]+numbers[j];
                    numbers[j]=numbers[j+1]-numbers[j];
                    numbers[j+1]=numbers[j+1]-numbers[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers={2,4,5,7,8,2,3,5,6};
        bubbleSort(numbers);
        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
    }
}
