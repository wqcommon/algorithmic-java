package com.algorithmic.algorithmic.dynamicprogramming;

/**
 * 背包问题
 * 描述：
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]（你不可以将物品进行切割。）
 *
 * 样例：
 * 如果有4个物品[2, 3, 5, 7]
 * 如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
 * 如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
 * 函数需要返回最多能装满的空间大小
 */
public class BackPack {

    public static void main(String[] args) {
        int[] A = {2,3,5,7};
        System.out.println(backPack(12,A));
        System.out.println(backPack2(12,A));
    }

    /**
     * 背包问题（0-1背包）
     * 时间复杂度 O(n * m)
     * 空间复杂度 O(n * m)
     * 应用动态规划来解决该问题
     * 解题思路：
     * 对于每个物品，需要根据之前放置的物品来判断是否可以放置该物品。找出m范围内被占用的最大空间
     * 对于物品i，空间j被占用有两种情况：
     * 1、当前物品不加入，空间j已经满了；C[i-1][j] = true;
     * 2、当前物品加入，空间j-A[i]恰好被前面的物品占用。j-A[i] >= 0 && C[i-1][j-A[i]] = true;
     * @param m
     * @param A
     * @return
     */
    private static int backPack(int m, int[] A) {
        // write your code here
        boolean[][] cArr = new boolean[A.length + 1][m + 1];//cArr[i][j]标识前i个物品是否能够填满空间j
        cArr[0][0] = true;//0个物品填满0空间
        for(int i = 1; i < cArr.length; i++){
            for(int j = 0; j < m + 1; j++){
                cArr[i][j] = cArr[i-1][j];
                if(j - A[i-1] >= 0 && cArr[i-1][j - A[i-1]]){
                    cArr[i][j] = true;
                }
            }
        }
        for(int k = cArr[A.length].length -1; k >= 1; k--){
            if(cArr[A.length][k]){
                return k;
            }
        }
        return 0;

    }

    /**
     *
     * 解题思路：
     * 1、用一个一维数组C[]来记录放置物品的过程，对每个物品更新一次数组
     * 2、按照空间从大到小更新，原因是当前物品对空间的占用都是在上一个物品放置的基础上。
     * 从大到小更新建立在之前物品对空间的占用情况，而从小到大更新可能重复将当前物品放入空间
     *
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m)
     * @param m
     * @param A
     * @return
     */
    private static int backPack2(int m,int[] A){
        boolean[] C = new boolean[m + 1];
        C[0] = true;
        for(int i = 0; i < A.length; i++){
            for(int j = m; j >= A[i]; j--){
                C[j] = C[j] || C[j - A[i]];
            }
        }
        for(int i = C.length - 1; i >= 1; i--){
            if(C[i]){
                return i;
            }
        }
        return 0;
    }


}