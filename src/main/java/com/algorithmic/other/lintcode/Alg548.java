package com.algorithmic.other.lintcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wenqiang
 * @date: 2019-12-05 19:20
 */
public class Alg548 {


    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int index = 0;
        int[] tempResult = new int[nums1.length];
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                tempResult[index++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        int[] result = new int[index];
        for(int m = 0; m < index; m++){
            result[m] = tempResult[m];
        }
        return result;
    }


    public int[] intersectionT1(int[] nums1, int[] nums2) {
        // write your code here
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Map<Integer,Integer> nums1Map = new HashMap<>();
        Map<Integer,Integer> nums2Map = new HashMap<>();
        for(int n : nums1){
            Integer count = nums1Map.get(n);
            if(count == null){
                count = 0;
            }
            count += 1;
            nums1Map.put(n,count);
        }
        for(int n : nums2){
            Integer count = nums2Map.get(n);
            if(count == null){
                count = 0;
            }
            count += 1;
            nums2Map.put(n,count);
        }
        int[] tmpResult = new int[nums1.length];
        int index = 0;
        for(Integer key : nums1Map.keySet()){
            Integer num1 = nums1Map.get(key);
            Integer num2 = nums2Map.get(key);
            if(num2 == null || num2 == 0){
                continue;
            }
            int num = num1 > num2 ? num2 : num1;
            for(int i = index; i < index + num; i++){
                tmpResult[i] = key;
            }
            index += num;
        }
        int[] result = new int[index];
        for(int i = 0; i < index; i++){
            result[i] = tmpResult[i];
        }
        return result;
    }
}
