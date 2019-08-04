package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-28 16:48
 *
 * 49. 字符大小写排序
 * 给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。
 */
public class Alg49 {

    public void sortLetters(char[] chars) {
        // write your code here
        int left = 0 , right =  chars.length - 1;
        while (left < right){

            //先找到大写字母
            while (left < right && chars[left] >= 97){
                left++;
            }
            while (left < right && chars[right] < 97){
                right--;
            }
            if(left < right){
                //交换
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
    }
}
