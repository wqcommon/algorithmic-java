package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/12 9:44
 *
 * 选择排序
 * 通过n-i次关键字的比较，从n-i+1个记录中选出关键字最小的记录，并和第i个记录交换
 * 关键步骤：
 * 1、在n-i+1个记录中选出关键字最小的记录
 * 2、交换
 *
 * 时间复杂度O(n^2),稍微优于冒泡排序
 */
public class SelectSortDemo {

    public static void main(String[] args) {
        int[] arr = {6,12,1,3,89,23,14,2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){

        for(int i = 0; i < arr.length -1; i++){
            int minInx = i;
            for(int j = i + 1;j < arr.length; j++){
                if(arr[j] < arr[minInx]){
                    minInx = j;
                }
            }
            if(minInx != i){
                arr[i] = arr[i] + arr[minInx];
                arr[minInx] = arr[i] - arr[minInx];
                arr[i] = arr[i] - arr[minInx];
            }
        }
    }
}
