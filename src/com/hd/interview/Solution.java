package com.hd.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求两数的和
 */
public class Solution {
//    public static int[] twonums(int[] nums,int target){
//        int[] numbers=new int[2];
//        for(int i=0;i<nums.length-1;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if (nums[i]+nums[j]==target){
//                    numbers[0]=i;
//                    numbers[1]=j;
//                    return numbers;
//                }
//            }
//        }
//            return numbers;
//
//    }
//
//    public static int[] twonums(int[] nums,int target){
//        int[] numbers=new int[2];
//        Map<Integer,Integer> map=new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],i);
//        }
//        for(int i=0;i<nums.length;i++){
//            if (map.get(target-nums[i])!=null){
//                if (i<map.get(target-nums[i])){
//                    numbers[0]=i;
//                    numbers[1]=map.get(target-nums[i]);
//                }else if (i>map.get(target-nums[i])){
//                    numbers[0]=map.get(target-nums[i]);
//                    numbers[1]=i;
//                }else {
//                    continue;
//                }
//                return numbers;
//            }
//        }
//        return numbers;
//    }

    /**
     * 采用hashmap的方式，可以完成遍历一次即取到相应的值。时间复杂度达到O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twonums(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int current=target-nums[i];
            if (map.containsKey(current)){
                return new int[]{map.get(current),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,4,2};
        int[] ints = twonums(nums, 6);

        System.out.println(Arrays.toString(ints));
    }
}
