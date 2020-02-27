package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-12-19 20:11
 * 整数反转
 */
public class A_7 {


    public int reverse(int x) {
        /**
         * int值的类型范围为[-2147483648,2147283647]
         */
        int rev = 0;
        while (x != 0){
            int pop = x % 10;//当前要操作的数
            x = x / 10;//剩余的数
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
                //判断是否会溢出
                return 0;
            }
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < - 8)){
                //判断是否会溢出
                return 0;
            }
            rev =  rev * 10 + pop;
        }
        return rev;
    }
}
