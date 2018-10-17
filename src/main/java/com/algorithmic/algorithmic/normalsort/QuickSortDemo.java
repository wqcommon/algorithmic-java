package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/15 15:40
 *
 * 快速排序
 *
 * 基本思路：
 * 通过一趟排序将待排序的记录分割成独立的两部分，其中一部分记录的关键字均比另一部分记录的关键字小，
 * 然后分别对这两部分记录继续进行排序，以达到整个序列有序的目的
 *
 * 时间复杂度O(nlogn)
 */
public class QuickSortDemo {


    public static void main(String[] args) {
        int[] arr = {6,12,1,3,89,23,14,2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr){
        recursiveSort(arr,0,arr.length-1);

    }


    /**
     * 使用递归实现快速排序
     * @param arr
     * @param start
     * @param end
     */
    private static void recursiveSort(int[] arr,int start,int end){

        if(start < end){
            //获取分界值的下标
            int pivot = parition(arr,start,end);
            recursiveSort(arr,start,pivot - 1);
            recursiveSort(arr,pivot + 1,end);
        }

    }

    /**
     * 获取分界值的索引位置
     *
     * 整个过程是来回移动枢纽值
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int parition(int[] arr, int start, int end) {

        /**
         * NOTE:获取枢纽值，能够采用中位数的方式来获取，比如采用3位数取中：第一个，最后一个，中间一个，取它们中位数
         *
         * 9位数取中：分三组取样，先分别获取中位数，再在3个中位数中再取中位数
         *
         * 然后交互该值与数组头元素的值
         */

        int pivotVal = arr[start];
        while (start < end){
            //当枢纽值为起始值时，必须从数组尾部开始查找
            while (start < end && arr[end] >= pivotVal){
                end--;
            }
            //找到比pivot值小的位置，交换值
            //swap(arr,start,end);
            //优化
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivotVal){
                start++;
            }
            //找到比pivot值大的位置，交换值
            //swap(arr,start,end);
            arr[end] = arr[start];
        }
        arr[start] = pivotVal;
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        if(start != end){
            arr[start] = arr[start] + arr[end];
            arr[end] = arr[start] - arr[end];
            arr[start] = arr[start] - arr[end];
        }
    }
}
