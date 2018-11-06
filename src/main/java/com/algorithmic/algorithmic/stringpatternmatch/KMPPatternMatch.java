package com.algorithmic.algorithmic.stringpatternmatch;

/**
 * KMP模式匹配算法
 */
public class KMPPatternMatch {


    public static void main(String[] args) {
        String sString = "goodgoogle";
        String tString = "google";
        int index = KMPMatch(sString,tString);
        System.out.println("索引为：" + index);
    }

    /**
     * KMP模式匹配
     * @param sString 源字符串
     * @param tString 模式字符串
     * @return 若源串中包含模式子串，返回模式字符串中第一个字符出现的位置，如果源串中不包含模式子串返回-1
     */
    private static int KMPMatch(String sString,String tString){

        char[] sChars = sString.toCharArray();
        char[] tChars = tString.toCharArray();
        //求出next数组
        int[] next = new int[tChars.length];
        getNextArr(tString,next);
        //判断是否匹配
        int j = 0,i = 0;
        while (j < tChars.length && i < sChars.length){
            if(j == -1 || sChars[i] == tChars[j]){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == tChars.length){
            return i - j;
        }else {
            return -1;
        }
    }

    /**
     * 获取next数组
     * @param tString
     * @param next
     */
    private static void getNextArr(String tString, int[] next) {

        char[] tChars = tString.toCharArray();
        next[0] = -1;
        next[1] = 0;
        for(int i = 2; i < tChars.length; i++){
            int j = i - 1;
            while (next[j] != -1 && tChars[next[j]] != tChars[j]){
                j = next[j];
            }
            next[i] = next[j] + 1;
        }
    }
}
