package com.algorithmic.algorithmic.stringpatternmatch;

/**
 * 字符串朴素模式匹配
 *
 * 效率很低
 * 时间复杂度 O(m*(n-m)) 其中，m为子串的长度，n为主串的长度
 */
public class StringPlainPatternMatch {

    public static void main(String[] args) {
        System.out.println(plainPatternMatch("goodgoogle","goxxxod"));
    }


    /**
     *
     * @param sString 源串
     * @param dString 待查找的子串
     * @return 待查找子串在源串的第一个字符位置
     */
    private static int plainPatternMatch(String sString,String dString){

        for(int i = 0; i<= sString.length() - dString.length(); i++){
            int idx = i;
            for(int j = 0; j < dString.length(); j++){
                if(sString.charAt(idx) != dString.charAt(j)){
                    break;
                }
                idx++;
            }
            if((idx - i) == dString.length()){
                return i;
            }
        }
        return -1;

    }
}
