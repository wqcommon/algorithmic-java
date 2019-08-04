package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-28 09:56
 *
 * 45. 最大子数组差
 * 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。
 */
public class Alg45 {

    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int size = nums.length;
        int[] leftMin = new int[size]; //从左开始，到下标i的最小值
        int[] leftMax = new int[size]; //从左开始，到下标i的最大值
        int[] rightMin = new int[size]; //从右开始，到下标i的最小值
        int[] rightMax = new int[size]; //从右开始，到下标i的最大值

        //left
        for(int i = 0; i < size - 1; i++){
            if(i == 0){
                leftMin[i] = leftMax[i] = nums[i];
            }else {
                //max
                if(leftMax[i - 1] <= 0) {
                    leftMax[i] = nums[i];
                }else {
                    leftMax[i] = leftMax[i - 1] + nums[i];
                }

                //min
                if(leftMin[i - 1] >= 0){
                    leftMin[i] = nums[i];
                }else {
                    leftMin[i] = leftMin[i - 1] + nums[i];
                }
            }
        }

        //right
        for(int i  = size - 1; i > 0; i--){
            if(i == size - 1){
                rightMin[i] = rightMax[i] = nums[i];
            }else {

                //max
                if(rightMax[i + 1] <= 0){
                    rightMax[i] = nums[i];
                }else {
                    rightMax[i] = rightMax[i + 1] + nums[i];
                }

                //min
                if(rightMin[i + 1] >= 0){
                    rightMin[i] = nums[i];
                }else {
                    rightMin[i] = rightMin[i+ 1] + nums[i];
                }
            }
        }

        int max = 0;
        for(int i = 0; i < size - 1; i++){
            int tmpMax = Math.max(Math.abs(leftMax[i] - rightMin[i+1]),Math.abs(leftMin[i] - rightMax[i+1]));
            max = Math.max(max,tmpMax);
        }
        return max;

    }


}
