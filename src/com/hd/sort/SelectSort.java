package com.hd.sort;

import java.util.jar.JarEntry;

/**
 * 选择排序
 * 时间复杂度O(n^2)
 * 稳定性：不稳定
 */
public class SelectSort {
    public static void selectSort(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            int k=i;
            for(int j=i;j<numbers.length;j++){
                if (numbers[j]>numbers[k]){
                    k=j;
                }
            }
//            numbers[i]*=numbers[k];
//            numbers[k]=numbers[i]/numbers[k];
//            numbers[i]=numbers[i]/numbers[k];
            int temp=numbers[i];
            numbers[i]=numbers[k];
            numbers[k]=temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers={2,4,5,7,8,9,2,3,6,1,2};
        selectSort(numbers);
        for (int number : numbers) {
            System.out.println(number);

        }
    }
}
