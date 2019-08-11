package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-08-11 17:23
 *
 * 搜索区间
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 * 如果目标值不在数组中，则返回[-1, -1]
 */
public class Alg61 {

    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] retArr = {-1,-1};
        if(A == null || A.length == 0){
            return retArr;
        }
        //先定位数组中是否存在该元素
        int start = 0;
        int end = A.length - 1;
        int mid = -1;
        while ((start <= end)){
            mid = (start + end) / 2;
            if(A[mid] == target){
                break;
            }else if(A[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(A[mid] != target){
            return retArr;
        }
        if(start == end){
            retArr[0] =  retArr[1] = start;
            return retArr;
        }
        int l1 = start;
        int e1 = mid;
        while (l1 <= e1){
            int m = (l1 + e1) / 2;
            if(A[m] == target){
                e1 = m;
            }else {
                //此时一定比target小
                l1 = m + 1;
            }
            if(l1 == e1) break;
        }
        retArr[0] = e1;

        int l2 = mid;
        int e2 = end;
        while (l2 <= e2){
            int m = (l2 + e2 + 1) / 2;
            if(A[m] == target){
                l2 = m;
            }else {
                //此时一定比target大
                e2 = m - 1;
            }
            if(l2 == e2)break;
        }
        retArr[1] = l2;
        return retArr;



    }
}
