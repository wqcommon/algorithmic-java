package com.algorithmic.algorithmic.topicalgorith;

/**
 * @author qiang.wen
 * @date 2018/9/26 9:38
 *
 * 最大公约数
 */
public class MaximumCommonDivisor {


    public static void main(String[] args) {
        System.out.println(divisorOne(15,13));
        System.out.println(divisorTwo(10,25));
        System.out.println(divisorThree(10,25));
    }


    /**
     * 使用 欧几里得算法（辗转相除法）
     * 欧几里得定理：两个正整数a和b(a > b),它们的最大公约数等于 a除以b的余数c和b之间的最大公约数
     * 如：10和25,25除以10商2余5，那么10和25的最大公约数等同于10和5的最大公约数
     * 直到两个数能整除，除数为最大公约数
     *
     * 缺点：当两个整数较大时，做a%b取模运算的性能会比较低
     * @param a
     * @param b
     * @return
     */
    public static int divisorOne(int a,int b){

        if(a < b){
            return divisorOne(b,a);
        }
        if(a % b == 0){
            return b;
        }
        return divisorOne(b,a % b);
    }


    /**
     *  使用 更相减损术
     *  定理：两个正整数a和b（a > b）,它们的最大公约数等于 a-b 的差值c和较小数b的最大公约数。
     *  例如： 10 和25，那么10和25的最大公约数为15 和 10的最大公约数
     *  直到两个数相等，则这个数为最大公约数
     *
     *  缺点：不稳定，当两数相差很悬殊的话，如10000 和 1，就要递归9999次
     *
     * @param a
     * @param b
     * @return
     */
    public static int divisorTwo(int a, int b){
        if(a < b){
           return divisorTwo(b,a);
        }
        if(a == b){
            return a;
        }
        return divisorTwo(b,a - b);

    }


    /**
     * 在更相减损术的基础上使用移位运算
     * @param a
     * @param b
     * @return
     */
    public static int divisorThree(int a, int b){
        if( a < b){
            return divisorThree(b,a);
        }
        if( a == b){
            return a;
        }
        if((a&1) == 0 && (b&1) == 0){
            //a和b为偶数
            return divisorThree(a >> 1, b >> 1) << 1;
        }
        if((a&1) == 0 && (b&1) == 1){
            //a为偶数,b为奇数
            return divisorThree(a >> 1, b);
        }
        if((a&1) == 1 && (b&1) == 0){
            return divisorThree(a, b >> 1);
        }
        return divisorThree(b,a - b);

    }
}
