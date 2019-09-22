package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-09-21 15:38
 *
 * 78. 最长公共前缀
 * 给k个字符串，求出他们的最长公共前缀(LCP)
 */
public class Alg78 {

    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs == null || strs.length == 0){
            return "";
        }
        int lcpLen = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            String currStr = strs[i];
            String preStr = strs[i - 1];
            int rlen = lcpLen > currStr.length() ? currStr.length() : lcpLen;
            if(rlen == 0){
                //出现空字符串
                lcpLen = 0;
                break;
            }
            for(int j = 0; j < rlen; j++){
                if(preStr.charAt(j) !=  currStr.charAt(j)){
                    lcpLen = j;
                    break;
                }
            }
            if(lcpLen == 0){
                break;
            }
        }
        if(lcpLen == 0){
            return "";
        }
        return strs[0].substring(0,lcpLen);

    }

    public String longestCommonPrefix2(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j  = 0;
            while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)){
                j++;
            }
            if(j == 0){
                return "";
            }
            prefix = strs[i].substring(0,j);
        }
        return prefix;
    }

}
