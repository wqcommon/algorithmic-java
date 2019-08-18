package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-08-18 18:08
 *
 * 63. 搜索旋转排序数组 II
 * 写出一个函数判断给定的目标值是否出现在数组中。
 */
public class Alg63 {


    /**
     * 这个问题考察的是最坏情况的考虑
     * 例如：【1，1，1，1，1】中找出0，最坏情况时间复杂读为O(n)
     *
     * @param A
     * @param target
     * @return
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return false;
        }
        for (int val : A){
            if(val ==  target){
                return true;
            }
        }
        return false;

    }
}
