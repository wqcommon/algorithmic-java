package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-12-17 20:16
 * 二进制求和
 */
public class Alg_67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;//是否进一位
        /**
         * 1、使用ASCII值进行运算
         * 2、两个字符串长度补齐（不足用0补齐）
         */
        for(int i = a.length() - 1,j = b.length() - 1; i >= 0 || j >= 0;i--,j--){
            int sum = ca;
            sum += (i >= 0? a.charAt(i) - '0' : 0);
            sum += (j >=0? b.charAt(j) - '0' : 0);
            sb.append(sum % 2);
            ca = sum/2;
        }
        sb.append(ca == 1 ? 1 : "");
        return sb.reverse().toString();
    }



    public String addBinary2(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int i = aChars.length - 1,j = bChars.length - 1;
        StringBuffer sb = new StringBuffer();
        boolean needCarry = false;
        while (i >= 0 && j >= 0){
            char ac = aChars[i];
            char bc = bChars[j];
            if(ac == '0' && bc == '0'){
                if(needCarry){
                    sb.append('1');
                }else {
                    sb.append('0');
                }
                needCarry = false;
            }else if((ac == '0' && bc == '1') || (ac == '1' && bc == '0')){
                if(needCarry){
                    sb.append('0');
                    needCarry = true;
                }else {
                    sb.append('1');
                    needCarry = false;
                }
            }else {
                if(needCarry){
                    sb.append('1');
                }else {
                    sb.append('0');
                }
                needCarry = true;
            }
            i--;
            j--;
        }
        while (i  >= 0){
            if(needCarry){
                if(aChars[i] == '0'){
                    sb.append('1');
                    needCarry = false;
                }else {
                    sb.append('0');
                    needCarry = true;
                }
            }else {
                sb.append(aChars[i]);
            }
            i--;
        }

        while (j >= 0){
            if(needCarry){
                if(bChars[j] == '0'){
                    sb.append('1');
                    needCarry = false;
                }else {
                    sb.append('0');
                    needCarry = true;
                }
            }else {
                sb.append(bChars[j]);
            }
            j--;
        }
        if(needCarry){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
