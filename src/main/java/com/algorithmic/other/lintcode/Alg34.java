package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-20 20:27
 *
 * 34. N皇后问题 II
 *
 * 根据n皇后问题，现在返回n皇后不同的解决方案的数量而不是具体的放置布局。
 */
public class Alg34 {


    public int totalNQueens(int n) {
        // write your code here
        if(n <= 0){
            return 0;
        }

        int[] arr = new int[n];
        int initVal = Integer.MAX_VALUE;
        for (int i  = 0; i < n; i++){
            arr[i] = initVal;
        }
        int row = 0, col = 0;
        int count = 0;
        while (row < n){

            while (col < n){

                boolean can = true;
                for(int i = 0; i < n; i++){
                    if(arr[i] == col || Math.abs(i - row) == Math.abs(arr[i] - col)){
                        can = false;
                        break;
                    }
                }
                if(can){
                    //放皇后
                    arr[row] = col;
                    col = 0;
                    break;
                }else {
                    col++;
                }
            }
            if(arr[row] == initVal){
                //当前行放不了皇后
                if(row == 0){
                    //第一行，则整个结束
                    break;
                }else {
                    row--;
                    col = arr[row] + 1;
                    arr[row] = initVal;
                    continue;
                }
            }
            if(row == n -1){
                //最后一行皇后也放好了
                count++;
                col = arr[row] + 1;
                arr[row] = initVal;
                continue;
            }
            row++;

        }

        return count;
    }


}
