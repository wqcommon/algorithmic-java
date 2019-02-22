package com.algorithmic.other.lintcode;

/**
 * 反转一个只有3位数的整数。
 */
public class Alg37 {

    public int reverseInteger(int number) {
        // write your code here
       int first = number/100 * 1;
       int second = (number%100)/10 * 10;
       int third = ((number%100)%10) * 100;
       return third + second + first;
    }

}
