package com.hd.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个字符串中无重复字串的最大长度
 */
public class Solution4 {
    public static int lengthOfLongestSubstring(String s){
        int end=0;
        int start=0;
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        for(end=0,start=0;end<s.length();end++){
            if (!map.containsKey(s.charAt(end))){
                ans=Math.max(ans,end-start+1);
            }
            else {
                start=Math.max(start,map.get(s.charAt(end))+1);
                ans=Math.max(ans,end-start+1);
            }
            map.put(s.charAt(end),end);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="abcbacnc";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
