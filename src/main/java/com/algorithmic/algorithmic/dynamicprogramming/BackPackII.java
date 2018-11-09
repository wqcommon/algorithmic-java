package com.algorithmic.algorithmic.dynamicprogramming;

/**
 * 背包问题II
 * 问题描述：
 * 给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
 * 注意事项
 * A[i], V[i], n, m均为整数。你不能将物品进行切分。你所挑选的物品总体积需要小于等于给定的m。
 * 样例
 * 对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9。
 */
public class BackPackII {

    public static void main(String[] args) {
        int[] A = {2,3,5,7};
        int[] V = {1,5,2,4};
        System.out.println(backPack(10,A,V));
        System.out.println(backPackII(10,A,V));
    }

    /**
     * 背包问题II-解一
     *
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     * @param m
     * @param A
     * @param V
     * @return
     */
    private static int backPack(int m, int[] A, int[] V){
        int[][] dp = new int[A.length + 1][m + 1];//dp[i][j]表示i个物品背包大小j的最大价值
        /**
         * dp[i][j] = max{dp[i-1][j],dp[i-1][j-A[i]] + V[i](j-A[i] >= 0)}
         */
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i-1][j];
                if(j-A[i-1] >= 0 && dp[i-1][j-A[i-1]] + V[i-1] > dp[i][j]){
                    dp[i][j] = dp[i-1][j-A[i-1]] + V[i-1];
                }
            }
        }
        return dp[A.length][m];
    }


    /**
     * 背包问题II-解二
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m)
     * @param m
     * @param A
     * @param V
     * @return
     */
    private static int backPackII(int m, int[] A, int[] V){
        int[] dp = new int[m + 1];
        for(int i = 0; i < A.length; i++){
            for(int j = m; j >= A[i]; j--){
                if(dp[j] < dp[j - A[i]] + V[i]){
                    dp[j] = dp[j - A[i]] + V[i];
                }
            }
        }
        return dp[m];
    }

}
