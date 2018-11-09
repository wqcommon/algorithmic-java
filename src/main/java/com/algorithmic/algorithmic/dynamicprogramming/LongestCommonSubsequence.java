package com.algorithmic.algorithmic.dynamicprogramming;

/**
 * 最长公共子序列（LCS）
 *
 * 问题描述：
 * 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 *
 * 说明：
 * 最长公共子序列的定义：最长公共子序列问题是在一组序列（通常2个）中找到最长公共子序列（注意：不同于子串，LCS不需要是连续的子串）。
 * 该问题是典型的计算机科学问题，是文件差异比较程序的基础，在生物信息学中也有所应用。
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 *
 * 样例：
 * 给出"ABCD" 和 "EDCA"，这个LCS是 "A" (或 D或C)，返回1
 * 给出 "ABCD" 和 "EACB"，这个LCS是"AC"返回 2
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        System.out.println(calLongestCommonSubsequence("bedaacbade","dccaeedbeb"));

    }


    private static int calLongestCommonSubsequence(String s1,String s2){
            int[][] subLenArr = new int[s1.length() + 1][s2.length() + 1];
            int maxLen = 0;
            int temp = 0;
            for(int i = 1; i <= s1.length(); i++){
                for(int j = 1; j <= s2.length(); j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        subLenArr[i][j] = subLenArr[i-1][j-1] + 1;
                    }else{
                        temp = subLenArr[i][j-1] > subLenArr[i-1][j] ? subLenArr[i][j-1] : subLenArr[i-1][j];
                        subLenArr[i][j] = temp;
                    }
                    if(subLenArr[i][j] > maxLen){
                        maxLen = subLenArr[i][j];
                    }
                }
            }
            return maxLen;
    }

}
