package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/16 10:49
 *
 * 计数排序
 *
 * 计数排序：该算法不是基于比较，而是利用数组下标来确定元素的正确位置
 *
 * 应用场景：适用于一定范围的整数排序，取值范围不是很大的情况下
 *
 * 局限性：
 * 1、数列最大最小值差距过大时，并不适用计数排序
 * 2、当数列元素不是整数时，并不适用计数排序
 *
 * 计数排序与桶排序的关系：
 * 计数排序是桶排序的一个特例，一个数据一个桶
 *
 *
 * 时间复杂度O(n)
 */
public class CountSortDemo {

    public static void main(String[] args) {
        int[] arr = {6,12,1,3,89,23,14,2};
        countSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 步骤：
     * 1、构造一个0到数组最大值的数组叫count，该数组用于表示数组元素出现的次数
     * 2、然后遍历数组，当某个元素的值与count数组的下标相是 count[i] = count[i] + 1
     * 3、遍历count数组，输出元素
     *
     * 这种方式比较粗糙，有几个问题：
     * 1、单纯的以最大值来构造数组的长度，可能会造成空间的浪费，如，84，87,90，这样在84之前的空间都浪费了
     * 2、这种方式并没有真正对原始数列进行排序，例如，对学生的考试分数，对于分数相同的无法知道是谁
     * @param arr
     */
    public static void countSort1(int[] arr){
        //获取元素的最大值
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int[] countArr = new int[max+1];
        for(int j = 0; j < arr.length; j++){
            countArr[arr[j]] += 1;
        }
        int idx = 0;
        for(int k = 0; k < countArr.length; k++){
            if(countArr[k] == 0){
                continue;
            }
            for(int m = 1; m <= countArr[k]; m++){
                arr[idx++] = k;
            }
        }
    }


    /**
     * 是朴素版的计数排序的优化版
     * 步骤：
     * 1、以数组元素最大值和最小值之间的差值构造统计数组count
     * 2、遍历数组元素与统计数组的下标对应，统计数组元素的值等于之前所有元素的值加上当前元素的值，这个值标识者最后元素的排列顺序
     * 3、从原数组的倒序进行遍历，输出元素
     *
     * @param arr
     */
    public static void countSort2(int[] arr){
        //获取最大值和最小值
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int[] countArr = new int[max - min + 1];
        for(int j = 0; j < arr.length; j++){
           countArr[arr[j] - min] += 1;
        }
        //遍历统计数组，从下标1开始，让每个元素的值等于该元素的值加上前面元素的和
        for(int k = 1; k < countArr.length; k++){
            countArr[k] = countArr[k] + countArr[k-1];
        }
        //构造一个输出数组,与输入数组arr的长度一样
        int[] outArr = new int[arr.length];
        for(int m = arr.length -1; m >= 0; m--){
            outArr[countArr[arr[m] - min] - 1] = arr[m];
            countArr[arr[m] - min]--;
        }
        for(int n = 0; n < outArr.length; n++){
            arr[n] = outArr[n];
        }

    }
}
