package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-08-11 15:19
 * 给一个包含n个数的整数数组S，在S中找到所有使得和为给定整数target的四元组(a, b, c, d)。
 */
public class Alg58 {

    /**
     * 思路：
     * 最简单的思路就是暴力破解，构造一个4维数组
     *
     * 另外实现的思路：
     * 采用动态规划来解决
     *
     *
     * @param numbers
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> retList = new ArrayList<>();
        if(numbers == null || numbers.length < 4){
            return retList;
        }
        Arrays.sort(numbers);
        if(numbers[0] > target){
            return retList;
        }
        for(int i = 0 ; i <= numbers.length - 4; i++){
            if(i > 0 && numbers[i] == numbers[i - 1])continue;
            int fTarget = target - numbers[i];
            for(int j = i + 1; j < numbers.length - 3; j++){
                if(j > i+1 && numbers[j] == numbers[j - 1])continue;
                int sTarget =  fTarget - numbers[j];
                int left = j + 1;
                int right = numbers.length - 1;
                while (left < right){
                    if(numbers[left] + numbers[right] == sTarget){
                        List<Integer> rets = new ArrayList<>();
                        rets.add(numbers[i]);
                        rets.add(numbers[j]);
                        rets.add(numbers[left]);
                        rets.add(numbers[right]);
                        retList.add(rets);
                        left++;
                        right--;
                        while (left < right && numbers[left] == numbers[left - 1]){
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right + 1]){
                            right--;
                        }
                    }else if(numbers[left] + numbers[right] < sTarget){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return retList;
    }
}
