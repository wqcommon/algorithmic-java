package com.algorithmic.datastructure.array;

import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/8/22 16:23
 *
 * 最大子数组II
 *
 * 问题描述：
 * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
 * 每个子数组的数字在数组中的位置应该是连续的。返回最大的和。
 *
 * NOTE:子数组最少包含一个数
 *
 * 例如：给出数组 [1, 3, -1, 2, -1, 2] 这两个子数组分别为 [1, 3] 和 [2, -1, 2] 或者 [1, 3, -1, 2] 和 [2]，它们的最大和都是 7
 *
 * 挑战：要求时间复杂度为 O(n)
 */
public class MaximumSubarrayTwo {

    public static void main(String[] args) {

    }


    /**
     * 时间复杂度o(n)
     * 遍历3次
     * @param nums
     * @return
     */
    private static int maximumArraySumOne(List<Integer> nums){
        Integer[] origNums = new Integer[nums.size()];
        nums.toArray(origNums);

        int[] leftArr = new int[nums.size()];//从左到右，每个index的最大值
        int[] rightArr = new int[nums.size()];//从右到左，每个index的最大值

        int leftSum = 0;
        int leftMax = origNums[0];
        for(int i = 0; i < origNums.length; i++){
            leftSum += origNums[i];
            leftMax = Math.max(leftMax,leftSum);
            leftSum = Math.max(leftSum,0);
            leftArr[i] = leftMax;
        }

        int rightSum = 0;
        int rightMax = origNums[origNums.length - 1];
        for(int i = origNums.length -1 ; i >= 0; i--){
            rightSum += origNums[i];
            rightMax = Math.max(rightMax,rightSum);
            rightSum = Math.max(rightSum,0);
            rightArr[i] = rightMax;
        }

        int max = leftArr[0] + rightArr[1];
        for(int i = 1; i < origNums.length - 1; i++){
            if(max < leftArr[i] + rightArr[i + 1]){
                max = leftArr[i] + rightArr[i + 1];
            }
        }
        return max;

    }
}
