package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/12 9:19
 *
 *  插入排序
 *
 *  将一个记录插入到已经排好序的有序表
 *  时间复杂度O(n^2),稍微优于选择排序
 */
public class InsertSortDemo {

    public static void main(String[] args) {
        int[] arr = {6,12,1,3,89,23,14,2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for(j = i -1; j >= 0 && arr[j] > temp; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }
}
