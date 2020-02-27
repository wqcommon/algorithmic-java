package com.algorithmic.algorithmic.stringpatternmatch;

/**
 * @author: wenqiang
 * @date: 2020-02-18 10:29
 *
 * KMP模式匹配算法
 */
public class KMPAlg {

    /**
     *  KMP算法的要点：
     *  1、next数组，next[i] 代表长度为i的字符串的前缀和后缀最大公共长度，当我们进行匹配时，当在索引为i的时候，发现不匹配，
     *  我们就需要使用的next[i],表示当前位置之前的字符串的前缀和后缀最大公共长度
     *  2、利用next[1]...next[i] 求出next[i+1]
     *  3、模式匹配的时候进行字符串的移动，保证源字符串不移动，只移动待匹配的字符串
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        KMPAlg alg = new KMPAlg();
        System.out.println(alg.position("abcacfabcabx","abcabx"));
    }

    /**
     * 判断t串是否在s串中，如果在，返回位置，不在，返回-1
     * @param s
     * @param t
     * @return
     */
    public int position(String s,String t){

        //求 next[]数组：next[i] 表示长度为i的字符串前缀和后缀的最大公共长度
        int[] next =  getNext(t);
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while (j > 0 && s.charAt(i) != t.charAt(j)){
                j = next[j];
            }
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }
            if(j == t.length()){
                return i - j + 1;
            }
        }
        return -1;
    }


    private int[] getNext(String t) {
        //求前缀和后缀的最大公共长度
        int[] next = new int[t.length()];

        int j = 0;
        for(int i = 1; i < t.length() - 1; i++){
            while (j > 0 && t.charAt(j) != t.charAt(i)){
                j = next[j];
            }
            if(t.charAt(j) == t.charAt(i)){
                j++;
            }
            next[i+1] = j;
        }
        return next;
    }
}
