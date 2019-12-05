package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-11-23 20:42
 */
public class A_29 {

    public static void main(String[] args) {
        A_29 a = new A_29();
        int res = a.divide(10,3);
        System.out.println(res);
        System.out.println(-10 >> 2);
    }

    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend ^ divisor) < 0; //判断结果是否为负数
        if(dividend > 0){
            dividend = - dividend;
        }
        if(divisor > 0){
            divisor = - divisor;
        }
        int result = 0;

        while(dividend <= divisor){
            int temp_res = -1;
            int temp = divisor;
            while(dividend <= (temp << 1)){
                //如果移位出现负数越界
                if(temp < Integer.MIN_VALUE >> 1) break;
                temp = temp << 1;
                temp_res = temp_res << 1;
            }
            dividend -= temp;
            result += temp_res;
        }
        return negative ? result : -result;
    }
}
