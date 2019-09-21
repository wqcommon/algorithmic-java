package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-09-14 19:16
 * 第一个错误的代码版本
 */
public class Alg74 {

    public static void main(String[] args) {
        new Alg74().findFirstBadVersion(2147483647);
    }

    public int findFirstBadVersion2(int n){
        int start = 1;
        int end = n;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else {
                start = mid;
            }
        }
        if(isBadVersion(start)){
            return start;
        }
        return end;

    }

    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 1;
        int end = n;
        int mid = -1;
        while (start < end){
            mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            if(isBad){
                if(isBadVersion(mid - 1)){
                    end = mid - 1;
                }else {
                    return mid;
                }
            }else {
                if(isBadVersion(mid + 1)){
                    return mid + 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return start;
    }

    private boolean isBadVersion(int v){
        if(v == 2147483647 ){
            return true;
        }
        return false;
    }
}
