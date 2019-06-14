package com.algorithmic.other.lintcode;

import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-06-01 18:36
 */
public class Alg39 {


    public void recoverRotatedSortedArray(List<Integer> nums) {

        if(nums == null || nums.size() <= 1){
            return;
        }
        //nums > 1
        //找到offset,这里的offset指的是从有序变成无序的索引
        int offset = -1;
        int size = nums.size();
        while (offset != 0){
            offset = 0;
            for(int i = 0; i < size - 1; i++){
                if(nums.get(i) > nums.get(i + 1)){
                    offset = i + 1;
                    size = size - offset;
                    break;
                }
            }
            if(offset > 0){
                //需要交换
                for(int i = offset - 1; i >= 0; i--){
                    int tmp = nums.get(i);
                    nums.set(i,nums.get(i + size));
                    nums.set(i + size,tmp);
                }
            }
        }

    }
}
