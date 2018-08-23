package com.algorithmic.datastructure.array;

import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/8/23 9:21
 *
 * 最小子数组
 * 描述：给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
 * NOTE:子数组最少包含一个数字
 * 例如：给出数组[1, -1, -2, 1]，返回 -3
 */
public class MinimumSubarrayOne {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    private static int minSubarray(List<Integer> nums){
        Integer[] origNums = new Integer[nums.size()];
        nums.toArray(origNums);

        int sum = 0;
        int minRet = origNums[0];
        for(int i = 0; i < origNums.length; i++){
            sum += origNums[i];
            minRet = Math.min(sum,minRet);
            sum = Math.min(sum,0);
        }

        return minRet;
    }
}
