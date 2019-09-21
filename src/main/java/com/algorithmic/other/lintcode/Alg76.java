package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-09-15 09:45
 */
public class Alg76 {

    //nlogn
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int[] minLast = new int[nums.length + 1];// 下标为LIS长度，元素为对应该LIS长度的最小元素值
        minLast[0] = Integer.MIN_VALUE;//保证不会成为最小的
        for(int i = 1; i <= nums.length; i++){
            minLast[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < nums.length; i++){
            int idx = binarySearch(minLast,nums[i]);
            minLast[idx] = nums[i];
        }
        for(int i = minLast.length - 1; i > 0; i--){
            if(minLast[i] != Integer.MAX_VALUE){
                return i;
            }
        }
        return 0;
    }


    private int binarySearch(int[] minLast, int num) {
        //这里要找出第一个比num大的下标
        int start = 0;
        int end = minLast.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if(minLast[mid] < num){
                start = mid;
            }else {
                end = mid;
            }
        }
        return end;
    }


    // n*n
    public int longestIncreasingSubsequence2(int[] nums){
        //动态规划
        int[] f = new int[nums.length]; //一维数组存储第i个数字的最大升序子串的长度
        int maxlen = 0;
        for(int i = 0; i < nums.length; i++){
            f[i] = 1;
            for(int j = 0; j < i;j++){
                if(nums[j] < nums[i]){
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
            }
            if(f[i] > maxlen){
                maxlen = f[i];
            }
        }
        return maxlen;

    }
}
