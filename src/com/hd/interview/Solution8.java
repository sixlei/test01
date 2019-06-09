package com.hd.interview;

public class Solution8 {
    public static int reverse(int x){
        if (x==0){
            return 0;
        }
        int n=1;
        StringBuffer buffer = new StringBuffer();
        if (x>0){
            while (x>0){
                if (n>1){

                    if (Integer.parseInt(buffer.toString())>Integer.MAX_VALUE/10||(Integer.parseInt(buffer.toString())==Integer.MAX_VALUE/10&&(x/n)%10>7)){
                        return 0;
                    }
                }
                buffer.append(x%10);
                x/=10;
                n++;
            }
        }else if (x<0){
            buffer.append('-');
            if (x==Integer.MIN_VALUE){
                return 0;
            }
            x=Math.abs(x);
            while (x>0){
                if (n>1){
                    if (Integer.parseInt(buffer.toString())<Integer.MIN_VALUE/10||(Integer.parseInt(buffer.toString())==Integer.MIN_VALUE/10&&x%10>8)){
                        return 0;
                    }
                }
                buffer.append(x%10);
                x=x/10;
                n++;
            }
        }


        return Integer.parseInt(buffer.toString());

//        int pop=0;
//        int rev=0;
//        while (x!=0){
//            pop=(x%10);
//            x/=10;
//            if (rev>Integer.MAX_VALUE/10||((rev==Integer.MAX_VALUE/10)&&pop>7)){
//                return 0;
//            }
//            if (rev<Integer.MIN_VALUE/10||((rev==Integer.MIN_VALUE/10)&&pop<-8)){
//                return 0;
//            }
//            rev=rev*10+pop;
//        }
//        return rev;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(2147483412));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println((-111)%10);
    }
}
