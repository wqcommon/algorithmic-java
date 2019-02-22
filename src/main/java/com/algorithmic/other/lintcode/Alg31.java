package com.algorithmic.other.lintcode;

/**
 * 31. 数组划分
 */
public class Alg31 {

    public static void main(String[] args) {

    }

    public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        //按照不同的位进行排序
        for(int sep = 1; max/sep > 0; sep *= 10){
            //
            int[] buketArr = new int[11];
            for(int i = 0; i < nums.length; i++){
                int buketIdx = nums[i]/sep%10;
                buketArr[buketIdx]++;
            }

            //当前元素的值等于前一个元素的值与当前元素的值之和
            for(int j = 1; j < buketArr.length; j++){
                buketArr[j] += buketArr[j-1];
            }

            int[] tempArr = new int[nums.length];
            for(int j = nums.length-1; j >= 0; j--){
                tempArr[buketArr[nums[j]/sep%10]-1] = nums[j];
                buketArr[nums[j]/sep%10]--;
            }
            for(int m = 0; m < tempArr.length; m++){
                nums[m] = tempArr[m];
            }
        }
        if(nums[nums.length - 1] < k){
            return nums.length;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            if(nums[(end + start)/2] >= k){
                end = (end + start)/2;
            }else {
                start = (end + start)/2 + 1;
            }
        }

       return start;
    }
}
