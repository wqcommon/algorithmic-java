package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-08-12 19:29
 *
 * 搜索旋转排序数组
 * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
 * 给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
 * 你可以假设数组中不存在重复的元素。
 */
public class Alg62 {

    /**
     * 默认数组是升序排列的
     * 该题的重点在于
     * 1、数组是部分有序的
     * 2、每次我们都只处理有序部分的数组（通过start和mid之间的值来判断）
     * @param A
     * @param target
     * @return
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while (start + 1 < end){
            mid = (start + end) / 2;
            if(A[mid] ==  target){
                return mid;
            }
            if(A[start] < A[mid]){
                //start 到 mid是有序的
                if(A[start] <= target && A[mid] >= target){
                    end = mid;
                }else {
                    start = mid;
                }
            }else {
                //mid 到 end是有序的
                if(A[mid] <= target && A[end] >= target){
                    start = mid;
                }else {
                    end = mid;
                }


            }

        }
        if(A[start] ==  target){
            return start;
        }
        if(A[end] ==  target){
            return end;
        }
        return -1;

    }


}
