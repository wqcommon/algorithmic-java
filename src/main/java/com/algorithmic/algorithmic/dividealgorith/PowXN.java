package com.algorithmic.algorithmic.dividealgorith;

/**
 * x的n次幂
 *
 * 描述：
 * 实现 pow(x,n)
 *
 * 样例：
 * Pow(2.1, 3) = 9.261
 * Pow(0, 1) = 0
 * Pow(1, 0) = 1
 *
 * 挑战：O(logn) time
 */
public class PowXN {

    public static void main(String[] args) {
        System.out.println(myPow(8.88023,3));
    }

    /**
     * 分治算法
     * @param x
     * @param n
     * @return
     */
    private static double myPow(double x, int n) {
        // write your code here
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 1 / (x * myPow(x,-(n+1)));
        }
        double ret = myPow(x,n/2);
        ret *= ret;
        if(n % 2 != 0){
            ret *= x;
        }
        return ret;

    }

}
