package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-08-10 21:40
 * 三数之和
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 */
public class Alg57 {

    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> retList = new ArrayList<>();
        if(numbers == null || numbers.length <= 2){
            return retList;
        }
        //升序排列
        Arrays.sort(numbers);
        if(numbers[0] > 0){
            return retList;
        }

        for(int i = 0; i <= numbers.length - 3;i++){
            if(i > 0 && numbers[i] == numbers[i-1] ){
                continue;
            }
            int taget = -numbers[i];//相反数
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right){

                if(numbers[left] + numbers[right] == taget){
                    List<Integer> rets = new ArrayList<>(3);
                    rets.add(-taget);
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
                }else if(numbers[left] + numbers[right] < taget){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return retList;
    }


    public void fakeCode(int[] nums){

        /**
         * 伪代码实现，时间复杂读n3
         */

        int[][][] rets = new int[nums.length][nums.length][nums.length];
        int size = nums.length;
        List<List<Integer>> retList = new ArrayList<>();
        for(int i = 0; i < size; i++){

            for(int j = 0; j < size; j++){

                for(int l = 0; l < size; l++){

                    if(i == j || j == l || l == i){
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[l];
                    if(sum == 0){
                        //判断是否已经存在了
                        //。。。。。
                    }

                }
            }
        }


    }
}
