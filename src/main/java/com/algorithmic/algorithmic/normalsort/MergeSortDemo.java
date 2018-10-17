package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/12 14:30
 *
 * 归并排序
 * 把两个有序数组合并为一个有序数组叫做2路归并排序
 * 把多个有序序列合并为一个有序序列叫做多路归并排序
 *
 * 时间复杂度O(nlogn)
 *
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {6,12,1,3,89,23,14,2};
//        mergeSort(arr);
        mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归实现归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr){

        sortArr(arr,0,arr.length - 1);

    }

    /**
     * 归并排序
     * @param arr
     * @param startIdx
     * @param endIdx
     */
    private static void sortArr(int[] arr, int startIdx, int endIdx) {
        if(startIdx == endIdx){
            return;
        }
        int midIdx = (endIdx + startIdx) / 2;
        sortArr(arr,startIdx,midIdx);
        sortArr(arr,midIdx + 1, endIdx);
        mergeArr(arr,startIdx,midIdx,endIdx);
    }

    /**
     * 合并有序数组
     * @param arr
     * @param startIdx
     * @param midIdx
     * @param endIdx
     */
    private static void mergeArr(int[] arr, int startIdx, int midIdx, int endIdx) {

        int[] tempArr = new int[endIdx - startIdx + 1];

        int i1 = startIdx,i2 = midIdx + 1;
        int idx = 0;
        while (i1 <= midIdx && i2 <= endIdx){
            if(arr[i1] < arr[i2]){
                tempArr[idx++] = arr[i1];
                i1++;
            }else {
                tempArr[idx++] = arr[i2];
                i2++;
            }
        }
        while (i1<= midIdx){
            tempArr[idx++] = arr[i1++];
        }
        while (i2<= endIdx){
            tempArr[idx++] = arr[i2++];
        }
        for(int i = 0; i < tempArr.length; i++){
            arr[startIdx + i] = tempArr[i];
        }

    }


    /**
     * 非递归实现归并排序
     * @param arr
     */
    public static void mergeSort2(int[] arr){

        int i = 1;//表示按几个元素进行归并排序
        while (i < arr.length){
            merge(arr,i,arr.length);
            i *= 2;
        }

    }

    /**
     * 归并
     * @param arr
     * @param k
     * @param length
     */
    private static void merge(int[] arr, int k, int length) {

        int i = 0;
        while (i <= length - 2*k){
            sort(arr,i,i+k-1,i+2*k-1);
            i += 2*k;
        }
        if(i < length-k){
            sort(arr,i,i+k-1,length-1);
        }

    }

    /**
     * 排序
     * @param arr
     * @param startIdx
     * @param midIdx
     * @param endIdx
     */
    private static void sort(int[] arr, int startIdx, int midIdx, int endIdx) {
        int[] tempArr = new int[endIdx - startIdx + 1];
        int i = startIdx,j = midIdx + 1, idx = 0;
        while (i <= midIdx && j <= endIdx){
            if(arr[i] < arr[j]){
                tempArr[idx++] = arr[i];
                i++;
            }else {
                tempArr[idx++] = arr[j];
                j++;
            }
        }
        while (i <= midIdx){
            tempArr[idx++] = arr[i++];
        }
        while (j <= endIdx){
            tempArr[idx++] = arr[j++];
        }
        for(int m = 0; m < tempArr.length; m++){
            arr[startIdx + m] = tempArr[m];
        }
    }
}
