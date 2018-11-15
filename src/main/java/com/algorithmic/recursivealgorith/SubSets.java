package com.algorithmic.recursivealgorith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 * 描述：
 * 给定一个含不同整数的集合，返回其所有的子集（子集中的元素排列必须是非降序的，解集必须不包含重复的子集）
 *
 * 样例：
 * 如果 S = [1,2,3]，有如下的解：
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */
public class SubSets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ret = solutionII(nums);
        System.out.println(ret);
    }

    /**
     * 非递归
     * @param nums
     * @return
     */
    private static List<List<Integer>> solutionI(int[] nums) {
        // write your code here
        List<List<Integer>> retList = new ArrayList<>();
        if(nums == null || nums.length == 0){
            retList.add(new ArrayList<>());
        }else {
            Arrays.sort(nums);
            retList.add(new ArrayList<>());
            for(int i = 0; i < nums.length; i++){
                List<List<Integer>> tList = new ArrayList<>();
                for(int k = 0; k < retList.size(); k++){
                    List<Integer> list = retList.get(k);
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.addAll(list);
                    tmpList.add(nums[i]);
                    tList.add(tmpList);
                }
                retList.addAll(tList);
            }
        }

        return retList;
    }


    /**
     * 递归
     * @param nums
     * @return
     */
    private static List<List<Integer>> solutionII(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        retList.add(new ArrayList<>());
        if(nums == null || nums.length == 0){
            return retList;
        }else {
            Arrays.sort(nums);
            return recur(retList,nums,0);
        }
    }

    private static List<List<Integer>> recur(List<List<Integer>> list,int[] nums,int idx){
        if(idx == nums.length){
            return list;
        }
        List<List<Integer>> tmpList = new ArrayList<>();
        for(List<Integer> l : list){
            List<Integer> t = new ArrayList<>();
            t.addAll(l);
            t.add(nums[idx]);
            tmpList.add(t);
        }
        list.addAll(tmpList);
        return recur(list,nums,++idx);
    }


}
