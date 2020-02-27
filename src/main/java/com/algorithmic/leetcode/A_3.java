package com.algorithmic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wenqiang
 * @date: 2019-12-12 19:32
 *
 * 无重复字符的最长子串
 *
 * 滑动窗口方法解决
 * 滑动窗口是数组/字符串问题中常用的抽象概念。
 */
public class A_3 {


    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0,i = 0, j = 0;
        //构造[i,j)的窗口
        while (i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
