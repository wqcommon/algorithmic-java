package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-28 21:47
 *
 * 43. 最大子数组 III
 * 给定一个整数数组和一个整数 k，找出 k 个不重叠子数组使得它们的和最大。每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 */
public class Alg43 {

    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums.length < k){
            //子数组最少得有一个元素
            return 0;
        }
        int len = nums.length;

        int[][] localMax = new int[k+1][len + 1];//包含第i个元素
        int[][] globalMax = new int[k+1][len + 1];//不一定包含第i个元素
        for(int i = 1; i <= k; i++){
            localMax[i][i - 1] = Integer.MIN_VALUE;
            for(int j = i; j <= len; j++){
                localMax[i][j] = Math.max(localMax[i][j-1],globalMax[i - 1][j-1]) + nums[j-1];
                if(i == j){
                     globalMax[i][j] = localMax[i][j];
                }else {
                    globalMax[i][j] = Math.max(globalMax[i][j-1],localMax[i][j]);
                }
            }
        }
        return globalMax[k][len];
    }

}
