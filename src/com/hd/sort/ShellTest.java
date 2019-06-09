package com.hd.sort;

/**
 * 希尔排序
 * 时间复杂度O(n^(1.3-2))
 * 稳定性：不稳定
 */

public class ShellTest {
    public static void shellsort(int[] numbers){
        int gap=numbers.length/2;
        while (gap>=1){
            for(int i=gap;i<numbers.length;i++){
                int base=numbers[i];
                int j=0;
                for(j=i-gap;j>=0&&numbers[j]>base;j=j-gap){
                    numbers[j+gap]=numbers[j];

                }
                numbers[j+gap]=base;
            }
            gap=gap/2;
        }
    }

    public static void main(String[] args) {
        int[] numbers={3,5,6,8,9,78,3,2,2,3,4,5,6,2,6,7,8,32};
        shellsort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
