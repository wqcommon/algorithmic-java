package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-07-07 09:10
 *
 * 15. 全排列
 * 你可以假设没有重复数字。
 * 使用递归和非递归分别解决。
 *
 */
public class Alg15 {

    public static void main(String[] args) {
        Alg15 alg15 = new Alg15();
        int[] nums = {1,2,3};
        List<List<Integer>> rets = alg15.permute(nums);
        rets.forEach(list ->{
            list.forEach(val ->{
                System.out.print(val + ",");
            });
            System.out.println();
        });
    }

    /**
     * 递归的方式
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> rets = new ArrayList<>();
        if(nums == null || nums.length == 0){
            rets.add(new ArrayList<>());
            return rets;
        }
        //深度优先遍历
        DFS(nums,new boolean[nums.length],new ArrayList<>(nums.length),rets);
        return rets;
    }

    private void DFS(int[] nums, boolean[] visited, List<Integer> tmpRet, List<List<Integer>> rets) {
        if(tmpRet.size() == nums.length){
            rets.add(new ArrayList<>(tmpRet));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
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
