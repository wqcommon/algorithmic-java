package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-09-22 15:37
 *
 * 83. 落单的数 II
 * 给出3*n + 1 个非负整数，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
 */
public class Alg83 {

    public static void main(String[] args) {
        int[] arr = {3,3,3,6};
        new Alg83().singleNumberII(arr);
    }

    /**
     *
     * 统计二进制位每位出现的次数，对3取余，剩下的就是出现一次的数字
     *
     */
    public int singleNumberII_1(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int[] bits = new int[32];
        int ret = 0;
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < A.length; j++){
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }
            ret |= bits[i] << i;
        }
        return ret;
    }

    public int singleNumberII(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int ones = 0; //出现1次
        int twos = 0; //出现2次
        for(int i = 0; i < A.length; i++){
            ones = ones ^ A[i] & (~twos);
            twos = twos ^ A[i] & (~ones);
        }
        return ones;
    }
}
