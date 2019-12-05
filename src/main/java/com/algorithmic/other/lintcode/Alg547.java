package com.algorithmic.other.lintcode;

import java.util.Arrays;

/**
 * @author: wenqiang
 * @date: 2019-12-02 19:38
 * 两数组的交集
 */
public class Alg547 {

    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0; int j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                if(index == 0 || temp[index - 1] != nums1[i]){
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        int[] result = new int[index];
        for(int m = 0; m < index; m++){
            result[m] = temp[m];
        }
        return result;
    }
}
