package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-14 10:59
 *
 * 32. 最小子串覆盖
 * 给定两个字符串 source 和 target. 求 source 中最短的包含 target 中每一个字符的子串.
 */
public class Alg32 {

    /**
     * 解题思路：
     * 1、target字符串中的字符在source字符串中可以是无序的
     * 2、构造一个数组存放target字符串中的字符出现的次数
     * 3、当sourceSum和targetSum相等的时候就代表此时source字符串中已经包含了target字符串中的所有字符
     *
     */
    public String minWindow(String source , String target) {
        // write your code here
        if(source == null || source == "" || target == null || target == ""){
            return "";
        }
        int[] targetArr = new int[256]; //英文字符的取值范围
        int targetNum = 0;
        for(int i = 0; i < target.length(); i++){
            targetArr[target.charAt(i)]++;
            targetNum++;
        }
        String minStr = "";
        int minLength = Integer.MAX_VALUE;
        int sourceNum = 0;

        for(int i = 0,j = 0; i < source.length(); i++){
            if(targetArr[source.charAt(i)] > 0){
                sourceNum++;
            }
            targetArr[source.charAt(i)]--;
            while (sourceNum >= targetNum){
                if(minLength > i + 1 - j){
                    minStr = source.substring(j,i + 1);
                    minLength = i + 1 - j;
                }
                targetArr[source.charAt(j)]++;
                if(targetArr[source.charAt(j)] > 0){
                    sourceNum--;
                }
                j++;
            }
        }
        return minStr;
    }
}
