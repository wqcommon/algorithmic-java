package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-10-27 20:44
 *
 *  爬楼梯
 *  假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 */
public class Alg111 {


    /**
     * 动态规划算法
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // write your code here
        if(n <= 1){
            //n为0，返回0
            //n为1，返回1
            return n;
        }
        int[] dp = new int[n + 1];//dp[i] 表示当需要i步到达顶部，有多少种方法到顶部
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
