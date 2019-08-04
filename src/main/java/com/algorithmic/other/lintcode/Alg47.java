package com.algorithmic.other.lintcode;

import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-07-28 14:03
 *
 * 47. 主元素 II
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
 */
public class Alg47 {


    public int majorityNumber(List<Integer> nums) {
        // write your code here
        return 0;
    }

    /**
     * 自己的实现方案
     *
     * 解题的思路：
     *
     * 主元素在数组中出现的次数大于数组元素个数的三分之一
     * 解题思路：
     * 1、遇到三个不同的元素则清除
     * 2、最后最多剩下2个不同的元素，这两个不同的元素中一定有一个是主元素
     * 3、遍历查询剩下的元素的出现的次数
     *
     * @param nums
     * @return
     */
    public int majorityNumber_self(List<Integer> nums) {
        // write your code here
        int num1 = 0,num2 = 0;
        int count1 = 0,count2 = 0;
        for (int i = 0; i < nums.size(); i++){
            int v = nums.get(i);
            if(count1 == 0){
                num1 = v;
                count1++;
            }else if (v == num1){
                count1++;
            }else if(count2 == 0){
                num2 = v;
                count2++;
            }else if(v == num2){
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.size(); i++){
            if(num1 == nums.get(i)){
                count1++;
            }else if(num2 == nums.get(i)){
                count2++;
            }
        }


        return count1 > count2 ? num1 : num2;

    }


}
