package com.algorithmic.other.lintcode;

import java.util.*;

/**
 * @author: wenqiang
 * @date: 2019-07-07 11:22
 *
 * 16. 带重复元素的排列
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 * 使用递归和非递归分别完成该题。
 */
public class Alg16 {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1};
        List<List<Integer>> rets = new Alg16().permuteUnique(nums);
        System.out.println(rets);
    }


    //递归方式
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> rets = new ArrayList<>();
        if(nums == null || nums.length == 0){
            rets.add(new ArrayList<>());
            return rets;
        }
        Arrays.sort(nums);//排序，把重复的数字放到一块
        DFS(nums,new boolean[nums.length],new ArrayList<>(),rets);
        return rets;
    }

    /**
     * 深度优先遍历
     * @param nums
     * @param visited
     * @param tmpRet
     * @param rets
     */
    private void DFS(int[] nums, boolean[] visited, List<Integer> tmpRet, List<List<Integer>> rets) {
        if(tmpRet.size() == nums.length){
            rets.add(new ArrayList<>(tmpRet));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || (i != 0 && !visited[i - 1] && nums[i - 1] == nums[i])){
                continue;
            }
            tmpRet.add(nums[i]);
            visited[i] = true;
            DFS(nums,visited,tmpRet,rets);
            tmpRet.remove(tmpRet.size() - 1);
            visited[i] = false;
        }
    }
}
