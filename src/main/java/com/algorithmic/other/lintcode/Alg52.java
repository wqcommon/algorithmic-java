package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-08-03 18:00
 *
 * 下一个排列
 * 给定一个整数数组来表示排列，找出其之后的一个排列。（按字典序排列）
 *
 * NOTE：排列中可能包含重复的整数
 */
public class Alg52 {

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        new Alg52().nextPermutation(nums);
    }

    public int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1){
            return nums;
        }
        //第一步：从右到左遍历，找到第一个nums[i] < nums[i+1]的下标
        int high = nums.length - 1 ;
        while (high - 1 >= 0 && nums[high - 1] >= nums[high]){
            high--;
        }
        high = high -1; //找出了下标
        //第二步，从右到左遍历，找出第一个比nums[high]的数的下标
        if(high >= 0){
            int low = nums.length - 1;
            while (low > high && nums[low] <= nums[high]){
                low--;
            }
            //第三步：交换high和low
            int tmp = nums[high];
            nums[high] = nums[low];
            nums[low] = tmp;

        }
        //第四步：从high+1开始到结束，进行升序排列
        //本身从high + 1到结束是一个降序排列
        int start = high + 1;
        int end = nums.length - 1;
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        return nums;
    }
}
