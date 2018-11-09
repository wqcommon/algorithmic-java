package com.algorithmic.algorithmic.greedyalgorith;

/**
 * 是否为子序列
 *
 * 问题描述：
 * 给定字符串s和t，判断s是否为t的子序列。
 * 你可以认为在s和t中都只包含小写字母。t可能是一个非常长（length ~= 500,000）的字符串，而s是一个较短的字符串（length <= 100）。
 * 一个字符串的子序列是在原字符串中删去一些字符（也可以不删除）后，不改变剩余字符的相对位置形成的新字符串（例如，"ace"是"abcde"的子序列而"aec"不是）。
 * 样例1：s = "abc"，t = "ahbgdc"  返回true
 * 样例2：s = "axc"，t = "ahbgdc" 返回false。
 *
 * 挑战：
 * 如果输入包含很多S串，例如为S1, S2, ..., Sk，其中k >= 1B，你想一个一个判断T是否包含这样的子序列。在这样的情形下，你会怎样修改你的代码呢？
 *
 */
public class ISsubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("axc","ahbgdc"));
    }

    /**
     * 判断s是否为t的子序列
     * @param s
     * @param t
     * @return
     */
    private static boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s == "" || t == ""){
            return false;
        }
        if(s.length() > t.length()){
            return false;
        }
        int idx = 0;
        for(int i = 0; i < t.length(); i++){
            if(idx < s.length() && s.charAt(idx) == t.charAt(i)){
                idx++;
            }
            if(idx == s.length()){
                return true;
            }
        }
        return false;
    }
}
