package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/8/27 15:46
 *
 *  堆排序
 *  使用完全二叉树实现
 *
 *  大顶堆：满足arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 *  小顶堆：满足arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 *
 *  时间复杂度 O(nlogn)
 *  空间复杂度O(1)
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4,2,3,8,9,10,1,18,34};
//        int[] arr = {3};
//        int[] arr = {3,1};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 升序排列，使用大顶堆
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr){
        makeHeap(arr,arr.length);
        for(int i = arr.length -1; i>0; i--){
            arr[i] = arr[i] + arr[0];
            arr[0] = arr[i] - arr[0];
            arr[i] = arr[i] - arr[0];
            makeHeap(arr,i);
        }
        return arr;
    }


    /**
     * 构造大顶堆，从最后一个叶子节点开始调整
     * @param arr
     * @param len
     */
    private static void makeHeap(int[] arr,int len){

        for(int i = len/2 -1; i >= 0; i--){
            adjustDown(arr,i,len);
        }

    }

    private static void adjustDown(int arr[],int i,int len){
        int j = 2 * i + 1;
        if(j < len){
            if (j + 1 < len && arr[j] < arr[j +1] ){
                j = j +1;
            }
            if(arr[i] < arr[j]){
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }

    }


}
