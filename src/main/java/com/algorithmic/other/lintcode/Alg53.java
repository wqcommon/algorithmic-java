package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-06-25 09:48
 *
 * 53. 翻转字符串中的单词
 *
 *  O(1)的空间复杂度：
 *  1、先翻转整个字符串
 *  2、再把每个单词翻转
 */
public class Alg53 {

    public static void main(String[] args) {
       String str = "I am a person";
       System.out.println(reverseWords2(str));
    }

    public String reverseWords(String s) {
        // write your code here
        s = s.trim();
        if(s.equals("")){
            return s;
        }
        String[] strArr = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = strArr.length - 1; i >= 0; i--){
            String str = strArr[i].trim();
            if(!str.equals("")){
                sb.append(str).append(" ");
            }
        }
        return sb.toString().trim();
    }

    /**
     * 空间复杂度O(1)
     *
     * 假设字符串前后没有空格
     * 假设中间不存在多个空格
     * 假设单词没有标点符号
     * @param s
     * @return
     */
    public static String reverseWords2(String s){
        if(s == null || s.equals("")){
            return s;
        }
        char[] chars = s.toCharArray();
        //翻转整个字符串
        int start = 0;
        int end = chars.length - 1;
        char tmp = '0';
        while (start < end){
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        int idx = 0;
        int sidx = 0;
        int eidx = 0;
        while (idx < chars.length){
            sidx = idx;
            eidx = idx;
            while (eidx < chars.length && chars[eidx] != ' '){
                eidx++;
            }
            idx = eidx + 1;//下一个字符
            char tp = '0';
            eidx = eidx - 1;
            while (sidx < eidx){
                tp = chars[sidx];
                chars[sidx] = chars[eidx];
                chars[eidx] = tp;
                sidx++;
                eidx--;
            }
        }
        return String.valueOf(chars);
    }
}
