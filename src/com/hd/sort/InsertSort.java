package com.hd.sort;

/**
 * 插入排序
 * 时间复杂度O(n^2)
 * 稳定性：稳定
 */
public class InsertSort {
    public static void insertSort(int[] numbers){
        for(int i=0;i<numbers.length-1;i++){
            int base=numbers[i+1];
            int j=0;
            for(j=i;j>=0&&numbers[j]>base;j--){
                numbers[j+1]=numbers[j];
            }
            numbers[j+1]=base;
        }
    }

    public static void main(String[] args) {
        int[] numbers={2,5,6,8,9,3,1,3,4,5,7};
        insertSort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }


}
