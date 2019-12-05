package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-12-05 20:17
 */
public class Alg524 {

    static public String leftPad(String originalStr, int size) {
        // Write your code here
        if(size == 0 || originalStr == null || originalStr.length() >= size){
            return originalStr;
        }
        char[] chars = new char[size - originalStr.length()];
        for (int i = 0; i < chars.length; i++){
            chars[i] = ' ';
        }
        return String.valueOf(chars) + originalStr;
    }

    /*
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // write your code here
        if(size == 0 || originalStr == null || originalStr.length() >= size){
            return originalStr;
        }
        char[] chars = new char[size - originalStr.length()];
        for (int i = 0; i < chars.length; i++){
            chars[i] = padChar;
        }
        return String.valueOf(chars) + originalStr;
    }
}
