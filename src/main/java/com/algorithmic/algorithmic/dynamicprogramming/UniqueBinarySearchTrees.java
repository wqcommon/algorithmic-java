package com.algorithmic.algorithmic.dynamicprogramming;

/**
 * 不同的二叉查找树
 *
 * 问题描述：
 * 给出 n，问由 1...n 为节点组成的不同的二叉查找树有多少种？
 * 样例：
 * 给出n = 3，有5种不同形态的二叉查找树：
 * 1           3    3       2      1
 *  \         /    /       / \      \
 *  3       2     1       1   3      2
 *  /      /       \                  \
 *  2     1         2                  3
 *
 *  f(0) = f(1) = 1;
 *  f(n) = f(n-1)f(0) + f(n-2)f(1) + f(n-3)f(2) + ... + f(2)f(n-3) + f(1)f(n-2) + f(0)f(n-1)
 *
 *  这个表达式叫Catalan数
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTrees(10));
        System.out.println(numTrees(0));
    }

    private static int numTrees(int n) {
        // write your code here
        if(n == 0){
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = nums[1] = 1;
        for(int i = 2; i < nums.length; i++){
            for(int j = i - 1,m = 0; j >= 0; j--,m++){
                nums[i] += nums[j]*nums[m];
            }
        }
        return nums[n];

    }
}
