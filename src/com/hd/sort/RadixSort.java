package com.hd.sort;

public class RadixSort {
    public static void radix(int[] numbers,int d){
        int length=numbers.length;
        int[][] base=new int[10][length];
        int[] radix=new int[10];
        int n=1;
        while (n<d){
            for(int i=0;i<length;i++){
                int k=(numbers[i]/n)%10;
                base[k][radix[k]]=numbers[i];
                radix[k]++;
            }
            int index=0;
            for(int i=0;i<10;i++){
                if (radix[i]>0){
                    for(int j=0;j<radix[i];j++){
                        numbers[index++]=base[i][j];
                    }
                    radix[i]=0;
                }
            }
            n*=10;
        }
    }

    public static void main(String[] args) {
        int[] numbers={23,53,65,23,68,54,32,89};
        radix(numbers,100);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
