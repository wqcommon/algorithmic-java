package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/12 11:29
 *
 * 希尔排序
 *
 * 将相距某个“增量”的记录组成一个子序列，这样能保证在子序列内分别进行插入排序后，得到结果时基本有序而不是局部有序
 *
 * 理解要点：
 * 1、增量：距离某个增量的记录组成一个子序列
 * 2、子序列内部使用插入排序
 *
 * 进阶版的插入排序
 *
 * 时间复杂度O(n^3/2)，优于插入排序
 */
public class ShellSortDemo {

    public static void main(String[] args) {

        int[] arr = {6,12,1,3,89,23,14,2};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 希尔排序
     *
     * 增量（希尔增量） h = h/3 + 1(h的初始值为数组长度，当h=1时终止)，增量序列的生成算法选择是个难题，一般我们就使用h=h/3+1
     * @param arr
     */
    public static void shellSort(int[] arr){
        int incre = arr.length;
        while (incre > 1){
            incre = incre/3 + 1;
            for(int i = incre; i < arr.length; i++){
                int temp = arr[i];
                int j = i - incre;
                for(; j >= 0 && temp < arr[j]; j = j - incre){
                   arr[j + incre] = arr[j];
                }
                arr[j + incre] = temp;
            }
        }
    }
}
