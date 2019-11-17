package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-11-10 11:34
 *
 * 买卖股票的最佳时机 II
 */
public class A_122 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int s = 0, e = 0;
        int maxProfit = 0;
        while (e <= prices.length - 1){
            if(e == prices.length -1){
                if(e > s){
                    maxProfit += prices[e] - prices[s];
                }
                break;
            }
            if(prices[e] > prices[e + 1]){
                maxProfit += prices[e] - prices[s];
                s = e = e + 1;
            }else {
                e = e + 1;
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int s = 0, e = 1;
        int maxProfit = 0;
        while (e <= prices.length - 1){
            if(prices[e] >= prices[e - 1]){
                e++;
            }else {
                maxProfit += prices[e-1] - prices[s];
                s = e;
                e++;
            }
        }
        if(s < prices.length - 1){
            maxProfit += prices[prices.length - 1] - prices[s];
        }
        return maxProfit;

    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] dp = new int[prices.length + 1];
        for(int i = 2; i < dp.length; i++){
           if(prices[i - 1] > prices[i - 2]){
               dp[i] = dp[i-1] + (prices[i-1] - prices[i-2]);
           }else {
               dp[i] = dp[i-1];
           }
        }
        return dp[dp.length - 1];

    }

}
