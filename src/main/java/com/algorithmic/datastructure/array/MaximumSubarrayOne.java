package com.algorithmic.datastructure.array;

/**
 * @author qiang.wen
 * @date 2018/8/22 14:22
 *
 * 最大子数组I
 *
 * 问题描述：
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 *
 * NOTE:子数组最少包含一个数
 *
 * 例如：给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
 *
 * 挑战：要求时间复杂度为O(n)
 */
public class MaximumSubarrayOne {


    public static void main(String[] args) {

    }

    /**
     * 时间复杂度为O(n²)
     * @param array
     * @return
     */
    private static int maximumArraySumOne(int[] array){

        int maxVal = array[0];
        for(int i = 0; i < array.length; i++){
            int maxTemp = array[i];
            int temp = array[i];
            for(int j = i + 1; j < array.length; j++){
                temp += array[j];
                if(maxTemp < temp){
                    maxTemp = temp;
                }
            }
            if(maxTemp > maxVal){
                maxVal = maxTemp;
            }

        }
        return maxVal;
    }

    /**
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    private static int maximumArraySumTwo(int[] nums){

        int sum = 0;
        int ret = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            ret = Math.max(sum,ret);
            sum = Math.max(sum,0);
        }
        return ret;
    }
}
