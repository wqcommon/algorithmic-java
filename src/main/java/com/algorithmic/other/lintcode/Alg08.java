package com.algorithmic.other.lintcode;


/**
 * @author: wenqiang
 * @date: 2019-05-31 17:19
 */
public class Alg08 {

    public static void main(String[] args) {

    }

    public static void rotateString(char[] str, int offset) {
        // write your code here
        if(str == null || str.length ==0){
            return;
        }
        int num = offset < str.length ? offset : offset % str.length;

        while (num > 0){
            char c = str[str.length -1 ];
            for(int i = str.length - 2; i >= 0; i--){
                str[i + 1] = str[i];
            }
            str[0] = c;
            num --;
        }

        System.out.println(String.valueOf(str));
    }
}
