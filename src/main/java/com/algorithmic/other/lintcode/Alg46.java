package com.algorithmic.other.lintcode;

import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-06-12 17:54
 *
 * 46. 主元素
 */
public class Alg46 {



    public int majorityNumber(List<Integer> nums) {
        // write your code here
        //类似消消乐的处理方式
        int count = 0;
        int num = 0;
        for (int i = 0; i < nums.size(); i++){
            if(count == 0){
                num = nums.get(i);
                count += 1;
            }else if(num == nums.get(i)){
                count += 1;
            }else {
                count -= 1;
            }

        }
        return num;
    }
}
