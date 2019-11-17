package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-10-26 20:09
 *
 * K数之和
 * 给定 n 个不同的正整数，整数 k（k <= n）以及一个目标数字 target。　
 * 在这 n 个数里面找出 k 个数，使得这 k 个数的和等于目标数字，求问有多少种方案？
 *
 * 动态规划问题
 * 本题未理解透彻
 */
public class Alg89 {

    public static void main(String[] args) {

    }

    public int kSum(int[] A, int k, int target) {
        // write your code here
        // dp[i][j][k] 代表从i个数中选出j个数的和为target的方案数
        int n = A.length;
        int[][][] dp = new int[n+1][k+1][target + 1];
        for(int i = 1; i <= n; i++){
            dp[i][0][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                for(int t = 1; t<= target; t++){
                    dp[i][j][t] = 0;
                    if(t >= A[i - 1]){
                        dp[i][j][t] = dp[i-1][j-1][t-A[i-1]];
                    }

                    /**
                     * 转换为dp[i][j][t] = dp[i-1][j-1][t-A[i-1]] + dp[i-1][j][t]
                     * 意思是包含第i个数的方案 + 不包含第i个数的方案
                     */
                    dp[i][j][t] += dp[i-1][j][t];

                }
            }
        }
        return dp[n][k][target];
    }
}
