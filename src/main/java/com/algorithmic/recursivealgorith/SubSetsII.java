package com.algorithmic.recursivealgorith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 * 描述：
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集（子集中的元素排列必须是非降序的，解集必须不包含重复的子集,两个子集间的顺序是无关紧要的）
 * <p>
 * 样例：
 * 如果 S = [1,2,2]，有如下的解：
 * [
 * [1],
 * [2],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubSetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> ret = solutionII(nums);
        System.out.println(ret);
    }

    /**
     * 非递归
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> solutionI(int[] nums) {
        // write your code here
        List<List<Integer>> retList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            retList.add(new ArrayList<>());
        } else {
            Arrays.sort(nums);
            retList.add(new ArrayList<>());
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> tList = new ArrayList<>();
                for (int k = 0; k < retList.size(); k++) {
                    List<Integer> list = retList.get(k);
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.addAll(list);
                    tmpList.add(nums[i]);
                    if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                        //可能重复
                        boolean cf = false;
                        for (int m = 0; m < retList.size(); m++) {
                            List<Integer> cList = retList.get(m);
                            if (tmpList.size() == cList.size() && cList.get(cList.size() - 1) == nums[i]) {
                                int l = 0;
                                for (; l < tmpList.size() - 1; l++) {
                                    if (tmpList.get(l) != cList.get(l)) {
                                        break;
                                    }
                                }
                                if (l == tmpList.size() - 1) {
                                    cf = true;
                                    break;
                                }
                            }
                        }
                        if (!cf) {
                            tList.add(tmpList);
                        }
                    } else {
                        tList.add(tmpList);
                    }
                }
                retList.addAll(tList);

            }
        }

        return retList;
    }

    private static List<List<Integer>> solutionII(int[] nums) {
        // write your code here
        List<List<Integer>> retList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            retList.add(new ArrayList<>());
        } else {
            Arrays.sort(nums);
            retList.add(new ArrayList<>());
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> tList = new ArrayList<>();
                for (int k = 0; k < retList.size(); k++) {
                    List<Integer> list = retList.get(k);
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.addAll(list);
                    tmpList.add(nums[i]);
                    if(!retList.contains(tmpList)){
                        tList.add(tmpList);
                    }
                }
                retList.addAll(tList);

            }
        }

        return retList;
    }
}
