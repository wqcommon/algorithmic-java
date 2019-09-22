package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-09-22 14:13
 * 82. 落单的数
 * 给出 2 * n + 1个数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 */
public class Alg82 {

    /**
     * 异或位运算：两个相同的值异或位运算之后为0
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        // write your code here
        //只能遍历一次，空间复杂度为O(1)
        if(A == null || A.length == 0){
            return -1;
        }
        int ret = 0;
        for(int i = 0; i < A.length; i++){
            ret = ret ^ A[i];
        }
        return ret;
    }
}
