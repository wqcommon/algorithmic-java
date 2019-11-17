package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-10-26 21:33
 *
 * k数和 II
 * 在这n个数里面找出K个数，使得这K个数的和等于目标数字，你需要找出所有满足要求的方案。
 *
 * 类似于组合数，从N个数中取K个数的所有方案都枚举一遍。
 */
public class Alg90 {


    // DFS
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if(A == null || A.length == 0){
            return ans;
        }
        List<Integer> tmpAns = new ArrayList<>();
        dfs(A,k,target,A.length - 1,tmpAns,ans);
        return ans;
    }

    private void dfs(int[] a, int k, int target, int index, List<Integer> tmpAns, List<List<Integer>> ans) {

        if(k == 0 && target == 0){
            ans.add(new ArrayList<>(tmpAns));
            return;
        }

        if(k < 0 || target < 0 || index < 0){
            return;
        }
        //第一种情况，前index-1个元素中有答案
        dfs(a,k,target,index - 1,tmpAns,ans);

        //第二种情况，包含index元素中有答案
        tmpAns.add(a[index]);
        dfs(a,k - 1,target - a[index],index - 1,tmpAns,ans);

        //回溯
        tmpAns.remove(tmpAns.size() - 1);
    }


}
