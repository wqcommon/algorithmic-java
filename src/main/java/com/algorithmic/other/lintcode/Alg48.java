package com.algorithmic.other.lintcode;

import java.util.*;

/**
 * @author: wenqiang
 * @date: 2019-07-28 16:05
 * 48. 主元素 III
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。
 */
public class Alg48 {


    public static void main(String[] args) {
        int [] nums = {3,1,2,3,2,3,3,4,4,4};
        List<Integer> ns = new ArrayList<>();
        for(int num : nums){
            ns.add(num);
        }
        new Alg48().majorityNumber(ns,3);
    }


    /**
     * 解题思路
     *
     * 最后最多剩下k-1个不同的元素
     * 在这些元素当中一定存在的主元素
     * @param nums
     * @param k
     * @return
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        //用HashMap存储
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i = 0; i < nums.size(); i++){
            Integer v = nums.get(i);
            Integer c = countMap.get(v);
            if(c == null || c == 0){
                countMap.put(v,1);
            }else {
                countMap.put(v,c + 1);
            }
            if(countMap.size() >= k){
                //删除key
                List<Integer> removeKeys = new ArrayList<>();
                for (Integer key : countMap.keySet()){
                    //不能边迭代边删除
                    Integer c1  = countMap.get(key);
                    if(c1 == 1){
                        removeKeys.add(key);
                    }else {
                        countMap.put(key,c1 - 1);
                    }
                }
                for(Integer key : removeKeys){
                    countMap.remove(key);
                }
            }
        }

        //遍历次数
        Set<Integer> keySet = countMap.keySet();
        Map<Integer,Integer> cMap = new HashMap<>();
        for(int i = 0; i < nums.size(); i++){
            int v = nums.get(i);
            if(keySet.contains(v)){
                Integer c = cMap.get(v);
                if(c == null){
                    cMap.put(v,1);
                }else {
                    cMap.put(v,c + 1);
                }
            }
        }

        //找出最大的
        int maxKey = 0,max = 0;
        for(Integer i : cMap.keySet()){
            Integer c = cMap.get(i);
            if(c > max){
                maxKey = i;
                max = c;
            }
        }

        return maxKey;
    }
}
