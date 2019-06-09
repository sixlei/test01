package com.hd.interview;

import sun.security.util.Length;

import javax.crypto.Cipher;
import java.util.logging.Level;

/**
 * 将字符串转换成整数
 */
public class Solution9 {
    public static int myAtoi(String str){

        StringBuffer buffer = new StringBuffer();
        str=str.trim();
        if (str==null||str.length()==0){
            return 0;
        }
        int k=0;
        for(int i=0;i< str.length();i++){
            if (str.charAt(i) == '+') {
                k++;
            }
            break;
        }
        if (k>=str.length()){
            return 0;
        }
        if (str.charAt(k)=='-'){
            buffer.append('-');
            for(int i=k;i<str.length();i++){
                if (str.charAt(i)=='-'){
                    continue;
                }
                if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    buffer.append(str.charAt(i));
                    if (i<str.length()-1){
                        char after = str.charAt(i + 1);
                        if (Integer.parseInt(buffer.toString())<Integer.MIN_VALUE/10||(Integer.parseInt(buffer.toString())==Integer.MIN_VALUE/10&&after>'8'&&after<='9'))
                            return Integer.MIN_VALUE;
                    }
                }else {
                    if (buffer.length()==1){
                        return 0;
                    }else {
                        return Integer.parseInt(buffer.toString());
                    }
                }
            }
            if (buffer.length()==1){
                return 0;
            }else{
                return Integer.parseInt(buffer.toString());
            }

        }else if (str.charAt(k)>='0'&&str.charAt(k)<='9'){
            for(int i=k;i< str.length();i++){
                if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    buffer.append(str.charAt(i));
                    if (i<str.length()-1){
                        char after = str.charAt(i + 1);
                        if (Integer.parseInt(buffer.toString()) > Integer.MAX_VALUE / 10 ||( Integer.parseInt(buffer.toString())==Integer.MAX_VALUE/10&&after>'7'&&after<='9'))
                            return Integer.MAX_VALUE;
                    }
                }else {
                    return Integer.parseInt(buffer.toString());

                }
            }
            if (buffer.length()==0){
                return 0;
            }else {
                return Integer.parseInt(buffer.toString());
            }

        }else {
            return 0;
        }

    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        String s="-";
        System.out.println(myAtoi(s));

    }
}
