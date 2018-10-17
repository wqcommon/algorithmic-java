package com.algorithmic.algorithmic.topicalgorith;

/**
 * @author qiang.wen
 * @date 2018/9/26 10:54
 *
 * 最小公倍数
 *
 * 两种方法：
 * 方法一：分解质因数
 *  最小公倍数 = 它们所有的质因数的乘积（如果存在不同数之间质因数相同的情况，则比较两数中哪个数的该质因数的个数更多，乘以较多的次数）
 * 方法二：公式法
 * 两个数的乘积 = 两个数的最大公约数 * 最小公倍数
 */

public class LeastCommonMultiple {

    public static void main(String[] args) {
        System.out.println(leastMultipe(5,10));
    }


    /**
     * 采用公式法
     * 两个数的乘积 = 两个数的最大公约数 * 最小公倍数
     * @param a
     * @param b
     * @return
     */
    private static int leastMultipe(int a,int b){
        //使用MaximumCommonDivisor类的最大公约数方法算出最大公约数
        int maxDivisor = MaximumCommonDivisor.divisorThree(a,b);
        return a * b / maxDivisor;
    }
}