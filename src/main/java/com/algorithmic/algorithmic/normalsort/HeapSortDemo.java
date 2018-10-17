package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/16 9:08
 *
 * 堆排序
 *
 * 堆是具有下列性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
 * 或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 *
 * 堆排序：利用堆（这里假设使用大顶堆）进行排序,思路如下：
 * 将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根结点。将它移走（将其与数组的末尾元素交换，此时末尾元素就是最大值），
 * 然后将剩余的n-1个序列重新构造成一个堆，这样就会得到n个元素中次小值，反复执行，最后得到一个有序序列
 *
 * 时间复杂度O(nlogn)
 */
public class HeapSortDemo {


    public static void main(String[] args) {
        int[] arr = {6,12,1,3,89,23,14,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr){

        for(int i = arr.length - 1; i > 0; i--){
            makeHeap(arr,i);
            swap(arr,0,i);
        }
    }

    private static void makeHeap(int[] arr, int endIdx){

        for(int i = (endIdx - 1)/2; i >= 0 ; i--){
            int tmpIdx = 2*i + 1;
            if((2*i+2) <= endIdx && arr[2*i + 2] > arr[2*i + 1]){
                tmpIdx = 2*i + 2;
            }
            if(arr[i] < arr[tmpIdx]){
                swap(arr,i,tmpIdx);
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
