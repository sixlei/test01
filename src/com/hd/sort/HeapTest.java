package com.hd.sort;

/**
 * 堆排序
 * 时间复杂度O(nlog(n))
 * 空间复杂度O(1)
 * 稳定性：不稳定
 */

/**
 *建立大顶堆，每次把最大数放到最后一位，完成排序
 */
public class HeapTest {
    public static void adjustHeap(int[] numbers,int i,int length){
        int base=numbers[i];
        for(int j=2*i+1;j<length;j=j*2+1){
            if (j+1<length&&numbers[j+1]>numbers[j]){
                j=j+1;
            }
            if (numbers[j]>base){
                numbers[i]=numbers[j];
                i=j;
            }else {
                break;
            }
        }
        numbers[i]=base;
    }
    public static void heapSort(int[] numbers){
        int length=numbers.length;
        for(int i=length/2;i>=0;i--){
            adjustHeap(numbers,i,length);
        }
        for(int i=length-1;i>=0;i--){
            int temp=numbers[i];
            numbers[i]=numbers[0];
            numbers[0]=temp;
            adjustHeap(numbers,0,i);
        }
    }

    public static void main(String[] args) {
        int[] numbers={2,5,6,8,9,2,1,3,5,9,5,8,8};
        heapSort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
