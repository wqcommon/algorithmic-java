package com.algorithmic.datastructure.array;

/**
 * @author qiang.wen
 * @date 2018/8/22 9:52
 *
 * 二分查找
 *
 * 问题描述：给定一个排序的整数数组（升序）和一个要查找的整数target，
 * 用O(logn)的时间查找到target第一次出现的下标（从0开始），
 * 如果target不存在于数组中，返回-1。
 *
 * 挑战：如果数组中的整数个数超过了2^32，你的算法是否会出错？
 *
 * 例如：在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。
 *
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,4,4,5,7,7,8,9,9,10};
        System.out.println(find(arr,1,0,arr.length-1));
    }


    private static int find(int[] originArr,int ele,int start,int end){
        if(start == end){
            if(originArr[start] == ele){
                return start;
            }else {
                return -1;
            }
        }
        int midIdx = (end + start)/2;
        if(ele <= originArr[midIdx]){
            return find(originArr,ele,start,midIdx);
        }else {
            return find(originArr,ele,midIdx + 1,end);
        }
    }

}
