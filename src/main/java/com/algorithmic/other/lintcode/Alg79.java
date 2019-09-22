package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-09-21 16:48
 */
public class Alg79 {


    /**
     * 思路：
     * 1、遍历B字符串每个字符
     * 2、算出以每个字符为开头在A中的最长子串的长度
     * 3、取其最大值
     */
    public int longestCommonSubstring1(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        int msl = 0;
        for(int i = 0; i < B.length(); i++){
            char c = B.charAt(i);
            int j = 0;
            while (j < A.length()){
                if(A.charAt(j) != c){
                    j++;
                    continue;
                }
                //相等
                int m = i;
                int n = j;
                int len = 0;
                while (m < B.length() && n < A.length() && B.charAt(m) == A.charAt(n)){
                    m++;
                    n++;
                    len++;
                }
                msl = msl >= len? msl : len;
                j++;
            }
        }
        return msl;
    }

    /**
     * Dp[i][j] 表示A的前i个字符与B的前j个字符中，且以第i个和第j个为结尾的公共子串的长度。
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        int m = A.length();
        int n = B.length();
        int[][] Dp = new int[m + 1][n+1]; // Dp[i][j] 表示A的前i个字符与B的前j个字符中，且以第i个和第j个为结尾的公共子串的长度。

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(A.charAt(i - 1) == B.charAt(j-1)){
                    Dp[i][j] = Dp[i-1][j-1] + 1;
                }else {
                    Dp[i][j] = 0;
                }
            }
        }

        int mcl = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j<= n; j++){
                if(Dp[i][j] > mcl){
                    mcl = Dp[i][j];
                }
            }
        }
        return mcl;
    }
}
