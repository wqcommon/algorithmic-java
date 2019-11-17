package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-11-03 21:04
 *
 * 116. 跳跃游戏
 */
public class Alg116 {

    public boolean canJump(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return false;
        }
        if(A.length == 1){
            return true;
        }
        /**
         * 贪心算法
         *
         * 在某个位置的步数以内选取最大的步数
         */
        int i = 0;
        while (i < A.length){
            if(A[i] == 0){
                return false;
            }
            if(i + A[i] >= A.length - 1){
                return true;
            }
            int max = 0;
            int m = 0;
            for(int j  = i + 1; j <= i + A[i];j++){
                if(A[j] >= max){
                    max = A[j];
                    m = j;
                }
            }
            i = m;
        }
        return false;
    }
}
