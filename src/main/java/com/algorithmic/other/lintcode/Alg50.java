package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-06-12 18:27
 *
 * 50. 数组剔除元素后的乘积
 *
 */
public class Alg50 {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(0);
        productExcludeItself(nums);
    }

    /**
     * 1、边界值的考虑不到位
     * 2、集合中add(index,val)和set(index,val)中对index的值有要求
     * 3、计算值时所取的值不对
     */
    public static List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> retList = new ArrayList<>(nums.size());
        long[] left = new long[nums.size()];
        long[] right = new long[nums.size()];
        //处理left
        int size = nums.size();
        long leftVal = 1;
        for(int i = 0; i < size; i++){
            if(i - 1 == 0){
                leftVal = nums.get(0);
            }else if(i - 1 > 0){
                leftVal = nums.get(i - 1) * left[i - 1];
            }
            left[i] = leftVal;
        }
        //处理right
        long rightVal = 1;
        for(int i = size - 1; i >= 0; i--){
            if(i + 1 == size - 1){
                rightVal = nums.get(size - 1);
            }else if(i + 1 < size - 1){
                rightVal = right[i + 1] * nums.get((i + 1));
            }
            right[i] = rightVal;
        }
        //计算最终结果
        for(int i = 0; i < nums.size(); i++){
            retList.add(i,left[i] * right[i]);
        }
        return retList;
    }
}
