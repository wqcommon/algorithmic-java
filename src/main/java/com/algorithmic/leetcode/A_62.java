package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-11-10 21:10
 */
public class A_62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1]; // m * n m列,n行
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
