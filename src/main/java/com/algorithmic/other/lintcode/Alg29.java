package com.algorithmic.other.lintcode;

/**
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 * 输入:"aabcc" "dbbca" "aadbbcbcac" 输出:true
 *
 * 这题的核心关键：
 * s3的开头字母一定是s1或s2的开头字母，采用递归判断，每次判断完头字母后，就移除s3头字母和匹配s3的头字母的s1或s2
 *
 */
public class Alg29 {

    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        if(s3.length() == 0){
            return true;
        }
        if(s1.length() > 0 && s3.charAt(0) == s1.charAt(0)){
            if(isInterleave(s1.substring(1),s2,s3.substring(1))){
                return true;
            }
        }
        if(s2.length() > 0 && s3.charAt(0) == s2.charAt(0) && isInterleave(s1,s2.substring(1),s3.substring(1))){
            return true;
        }
        return false;

    }
}
