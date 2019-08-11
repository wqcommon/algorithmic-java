package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-08-11 16:16
 *
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 * 你可以假设在数组中无重复元素。
 */
public class Alg60 {


    /**
     * 思路：
     * 1、二分查找
     * 2、当该元素在数组中不存在时，分为三种情况：
     *   a、该元素比所有元素都大
     *   b、该元素比所有元素都小
     *   c、该元素介于数组中的两个元素之间
     *
     *
     *
     * @param A
     * @param target
     * @return
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int start = 0;
        int end =  A.length - 1;
        while (start <= end){
            int idx = (start + end) / 2;
            if(A[idx]==target){
                return idx;
            }
            if(A[idx] < target){
                start = idx + 1;
            }else {
                end = idx - 1;
            }
        }
        if(start > 0 && start < A.length){
            return start - 1;
        }else {
            return start;
        }

    }
}
