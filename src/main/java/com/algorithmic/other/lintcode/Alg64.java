package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-08-25 15:46
 *
 * 64. 合并排序数组
 * 合并两个排序的整数数组A和B变成一个新的数组。
 */
public class Alg64 {

    public static void main(String[] args) {

    }


    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int[] retArr = new int[m+n];
        int i = 0;
        int j = 0;
        int l = 0;
        while (i < m && j < n){
            if(A[i] <= B[j]){
                retArr[l] = A[i];
                i++;
            }else {
                retArr[l] = B[j];
                j++;
            }
            l++;
        }
        while (i < m){
            retArr[l] = A[i];
            i++;
            l++;
        }
        while (j < n){
            retArr[l] = B[j];
            j++;
            l++;
        }
        for(int k = 0; k < A.length;k++){
            A[k] = retArr[k];
        }
    }
}
