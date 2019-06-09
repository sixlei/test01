package com.hd.interview;

/**
 * z的形状打印字符串
 */
public class Solution7 {
    public static String convert(String s, int numRows){
        if (s==null||s.length()==1){
            return s;
        }
        int gap=2*numRows-2;
        StringBuffer str=new StringBuffer();
        for(int i=0;i<numRows;i++){
            int j=i;
            while (j<s.length()){
                str.append(s.charAt(j));
                if ((j+gap-i*2)<s.length()&&(gap-i*2)!=gap&&(gap-i*2)!=0){
                    str.append(s.charAt(j+gap-i*2));
                }
                j=j+gap;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s="1234567890123456";
        String convert = convert(s, 4);
        System.out.println(convert);
    }
}
