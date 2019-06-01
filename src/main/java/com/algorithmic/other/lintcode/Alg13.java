package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-05-31 18:30
 */
public class Alg13 {

    public static void main(String[] args) {
        System.out.println(strStr("source", "rced"));
    }

    public static int strStr(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        if (source.length() < target.length()) {
            return -1;
        }
        char[] sChars = source.toCharArray();
        char[] tChars = target.toCharArray();
        int s = 0;
        // abcdf bcd
        while (s <= sChars.length - target.length()) {
            int j = 0;
            int i = s;
            while (i < sChars.length && j < tChars.length) {
                if (sChars[i] == tChars[j]) {
                    i++;
                    j++;
                } else {
                    //不相等
                    //是否第一个字符就不相等
                    s = j == 0 ? i + 1 : i;
                    break;
                }
            }
            if(j == tChars.length){
                return s;
            }

        }

        return -1;

    }
}
