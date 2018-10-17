package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/16 16:08
 *
 * 基数排序
 * 基数排序：
 * 桶排序的扩展
 * 将整数按位数切割成不同的数字，然后按每个位数分别进行比较
 * 具体做法：
 * 1、将所有待比较的数值统一为同样的数位长度，数位短的数前面补零。
 * 2、从最低位开始，依次进行依次排序
 * 3、从最低位一直最高位排序完成后，数列变成一个有序的序列
 *
 */
public class RadixSortDemo {

    public static void main(String[] args) {
        int[] arr = {52,126,856,1235,852,59,105,1298,79,6,8,24,21,30};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 基数排序
     * 对整数的每一位进行计数排序
     * @param arr
     */
    public static void radixSort(int[] arr){

        //获取最大数
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //按照不同的位进行排序
        for(int sep = 1; max/sep > 0; sep *= 10){
            //
            sort(arr,sep);
        }

    }

    /**
     * 排序
     * @param arr
     * @param sep
     */
    private static void sort(int[] arr, int sep) {
        //按照sep位进行计数排序
        int[] buketArr = new int[11];
        for(int i = 0; i < arr.length; i++){
            int buketIdx = arr[i]/sep%10;
            buketArr[buketIdx]++;
        }

        //当前元素的值等于前一个元素的值与当前元素的值之和
        for(int j = 1; j < buketArr.length; j++){
            buketArr[j] += buketArr[j-1];
        }

        int[] tempArr = new int[arr.length];
        for(int k = arr.length-1; k >= 0; k--){
            tempArr[buketArr[arr[k]/sep%10]-1] = arr[k];
            buketArr[arr[k]/sep%10]--;
        }
        for(int m = 0; m < tempArr.length; m++){
            arr[m] = tempArr[m];
        }

    }
}
