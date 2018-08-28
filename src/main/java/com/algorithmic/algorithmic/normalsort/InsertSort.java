package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/8/27 20:43
 *
 * 插入排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = {3,2,7,4,6,9,10,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i -1;
            for(; j >= 0; j--){
                if(temp < arr[j]){
                    arr[j + 1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }
}
