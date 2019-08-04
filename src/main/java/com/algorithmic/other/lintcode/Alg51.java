package com.algorithmic.other.lintcode;

import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-08-04 14:24
 *
 * 51. 上一个排列
 *
 * 给定一个整数数组来表示排列，找出其上一个排列。(按字典序)
 */
public class Alg51 {

    /**
     *
     * @param nums
     * @return
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0 || nums.size() == 1){
            return nums;
        }
        //第一步：从右至左查找，找出第一个nums[i-1] > nums[i]
        int i = nums.size() - 1;
        while (i-1 >= 0 && nums.get(i-1) <= nums.get(i)) {
            i--;
        }
        i = i - 1; // i的位置
        //第二步：从右至左查找，找出第一个nums[j] < nums[i]
        //第三步：交换
        if(i >= 0){
            //能找到第一步中的i
            int j = nums.size() - 1;
            while (j > i && nums.get(j) >= nums.get(i) ){
                j--;
            }
            int tmp  = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,tmp);
        }
        //第四步：从i+1开始做倒序排列(仅仅比当前排列小一点点)
        int start = i + 1;
        int end = nums.size() - 1;
        while (start < end){
            int tmp = nums.get(start);
            nums.set(start,nums.get(end));
            nums.set(end,tmp);
            start++;
            end--;
        }
        return nums;
    }

}
