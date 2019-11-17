package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-11-10 20:47
 */
public class A_53 {


    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length + 1]; // dp[i]:包含第i个元素的当前最大值
        dp[1] = nums[0];
        int max = nums[0];
        for(int i = 2; i < dp.length; i++){
           if(dp[i - 1] + nums[i-1] < nums[i - 1]){
               dp[i] = nums[i - 1];
           }else {
               dp[i] = dp[i-1] + nums[i-1];
           }
           if(dp[i] > max){
               max = dp[i];
           }
        }
        return max;
    }
}
