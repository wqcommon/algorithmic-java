package com.algorithmic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-11-17 21:04
 *
 * 组合总和
 */
public class A_39 {

    List<List<Integer>> retList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tmpRet = new ArrayList<>();
        recursive(tmpRet,candidates,target,0,0);
        return retList;
    }

    public void recursive(List<Integer> tempRet,int[] candidates,int target,int start,int sum){
        if(sum >= target){
            if(sum == target){
                List<Integer> ret = new ArrayList<>();
                ret.addAll(tempRet);
                retList.add(ret);
            }
            return;
        }
        for(int i = start; i < candidates.length; i++){
            tempRet.add(candidates[i]);
            recursive(tempRet,candidates,target,i,sum + candidates[i]);
            tempRet.remove(tempRet.size() - 1);
        }
    }
}
