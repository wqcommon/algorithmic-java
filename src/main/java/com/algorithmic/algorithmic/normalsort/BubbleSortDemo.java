package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/11 16:53
 *
 *  冒泡排序
 *  思想：逐个比较相邻的元素，若前一元素比后一元素大，交换位置
 *
 *  时间复杂度O(n^2)
 */
public class BubbleSortDemo {


    public static void main(String[] args) {

        int[] arr = {6,12,1,3,89,23,14,2};
//        bubbleSort(arr);
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){

        for(int i = 0; i < arr.length -1; i++){
            //只需要执行n-1次
            for(int j = 0; j < arr.length -1 - i; j++){
                //升序排列
                if(arr[j] > arr[j + 1]){
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }

    }

    /**
     * 冒泡排序，优化
     * 应用场景：在某个元素前都是有序的
     * @param arr
     */
    public static void bubbleSort2(int[] arr){

        for(int i = 0; i < arr.length -1; i++){
            boolean flag = false;//表示不需要再进行遍历比较了
            for(int j = 0; j < arr.length -1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }

    }
}
