package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/8/28 9:41
 * 快速排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7,4,2,8,5,10,34,23,14,3,1,45,24};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 快速排序
     *
     * @param arr
     * @param startIdx
     * @param endIdx
     */
    private static void quickSort(int[] arr, int startIdx, int endIdx) {
        if(startIdx >= endIdx){
            return;
        }
       int i = startIdx;
       int j = endIdx;
       int temp = arr[startIdx];
       while (i < j){

           while(i<j && arr[j] >= temp){
               j --;
           }
           if( j > i){
               arr[i] = arr[j];
           }
           while (i<j && arr[i] <= temp){
               i++;
           }
           if(i < j){
               arr[j] = arr[i];
           }
       }
       arr[j] = temp;
       quickSort(arr,startIdx,j-1);
       quickSort(arr,j + 1,endIdx);

    }

}
