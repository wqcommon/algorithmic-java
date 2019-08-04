package com.algorithmic.other.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wenqiang
 * @date: 2019-08-03 22:21
 *
 * 55. 比较字符串
 *
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 */
public class Alg55 {


    public boolean compareStrings(String A, String B) {
        // write your code here
        if(A == null || B == null){
            return false;
        }
        if(A.length() < B.length()){
            return false;
        }
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        Map<Integer,Integer> aCountMap = new HashMap<>();
        Map<Integer,Integer> bCountMap = new HashMap<>();
        for(int i = 0; i < aChars.length; i++){
            int key = aChars[i];
            Integer count = aCountMap.get(key);
            if(count == null){
                count = 1;
            }else {
                count += 1;
            }
            aCountMap.put(key,count);
        }

        for(int i = 0; i < bChars.length; i++){
            int key = bChars[i];
            Integer count = bCountMap.get(key);
            if(count == null){
                count = 1;
            }else {
                count += 1;
            }
            bCountMap.put(key,count);
        }

        for(Integer key : bCountMap.keySet()){
            Integer aVal = aCountMap.get(key);
            if(aVal == null){
                return false;
            }
            Integer bVal = bCountMap.get(key);
            if(aVal < bVal){
                return false;
            }
        }

        return true;
    }


    public boolean compareStrings2(String A, String B) {
        //counts首先记录A中所有的字符以及它们的个数，然后遍历B,如果出现counts[i]小于0的情况，说明B中该字符出现的次数
        //大于在A中出现的次数
        int[] counts = new int[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < A.length(); i++) {
            counts[A.charAt(i) - 'A'] ++;
        }
        for (int i = 0; i < B.length(); i++) {
            counts[B.charAt(i) - 'A'] --;
            if (counts[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }
}
