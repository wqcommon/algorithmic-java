package com.algorithmic.other.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wenqiang
 * @date: 2019-08-03 22:33
 *
 * 56. 两数之和
 *
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 *
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 *
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 */
public class Alg56 {

    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if(numbers == null){
            return null;
        }
        // key为target - numbers[i],value为i
        Map<Integer,Integer> valMap = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(valMap.get(numbers[i]) != null){
                int[] ret = {valMap.get(numbers[i]),i};
                return ret;
            }
            valMap.put(target - numbers[i],i);
        }
        int[] ret = {};
        return ret;
    }
}
