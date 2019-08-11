package com.algorithmic.other.lintcode;

import java.util.Arrays;

/**
 * @author: wenqiang
 * @date: 2019-08-11 15:48
 * 最接近的三数之和
 * 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。
 */
public class Alg59 {


    /**
     * 解题思路：
     * 第一种方案：暴力破解，采用一个三维数组来解决
     * 第二种方案：动态规划
     * @param numbers
     * @param target
     * @return
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length < 3){
            return 0;
        }
        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i <= numbers.length - 3; i++){
            if(i > 0 && numbers[i] == numbers[i - 1])continue;
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right){
                int tmpSum = numbers[i] + numbers[left] + numbers[right];
                if( tmpSum == target){
                    return tmpSum;
                }else if (tmpSum < target){
                    if(target - tmpSum < min){
                        min = target - tmpSum;
                        sum = tmpSum;
                    }
                    left++;
                }else {
                    if(tmpSum - target < min){
                        min = tmpSum - target;
                        sum = tmpSum;
                    }
                    right--;
                }
            }

        }
        return sum;
    }
}
