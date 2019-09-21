package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-09-14 14:52
 *
 *  寻找峰值
 */
public class Alg75 {

    public static void main(String[] args) {
        int[] A = {1,2,4,5,6,7,8,6};
        Alg75 alg75 = new Alg75();
        alg75.findPeak2(A);
    }

    public int findPeak(int[] A) {
        // write your code here
        int start = 0;
        int end = A.length - 1;
        while (end != 1 && start != A.length - 2 && (end - start) != 1){
            int mid = (start + end) / 2;
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                return mid;
            }
            if(A[mid] < A[mid - 1]){
                end = mid;
                continue;
            }

            if(A[mid] < A[mid + 1]){
                start = mid;
                continue;
            }
        }
        return -1;
    }


    public int findPeak2(int[] A) {
        // write your code here
        return find(A,0,A.length -1);
    }

    private int find(int[] A,int start,int end){
        if(end == 1 || start == A.length - 2 || (end - start) == 1){
            return -1;
        }
        int mid = (start + end) / 2;
        if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
            return mid;
        }else if(A[mid] < A[mid - 1] && A[mid] < A[mid + 1]){
            int idx = find(A,start,mid);
            if(idx == -1){
                idx = find(A,mid,end);
            }
            return idx;
        }else if(A[mid] < A[mid - 1]){
            return find(A,start,mid);
        }else {
            return find(A,mid,end);
        }

    }
}
