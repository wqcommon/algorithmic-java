package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-07-20 14:58
 *
 * 33. N皇后问题
 *
 * n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
 *
 * 给定一个整数n，返回所有不同的n皇后问题的解决方案。
 *
 * 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
 *
 * 解题思路：
 * 1、同一行上不能有多个皇后
 * 2、同一列上不能有多个皇后
 * 3、任意斜线上不能有多个皇后
 */
public class Alg33 {


    public static void main(String[] args) {
        new Alg33().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> retList = new ArrayList<>();
        if(n == 0){
            retList.add(new ArrayList<>(0));
            return retList;
        }
        final int initVal = Integer.MAX_VALUE;
        int[] queueArr = new int[n];//一维数组代表皇后所在的位置，i代表第i行的皇后所在的位置，queueArr[i]的值表示第几列
        //把值初始化为-1
        for(int i = 0; i < n; i++){
            queueArr[i] = initVal;
        }
        int i = 0,j = 0; //i代表行，j代表列
        while (i < n){

            while (j < n){
                //判断第i行第j列是否能够放皇后
                boolean canFlag = true;
                for(int m = 0; m < n; m++){
                    //斜线规律 行相减的绝对值 = 列相减的绝对值
                    if(queueArr[m] == j || Math.abs(m - i) == Math.abs(queueArr[m] - j)){ //用于判断斜线和同一列上是否产生冲突
                        canFlag = false;
                        break;
                    }
                }
                if(canFlag){
                    queueArr[i] = j;
                    j = 0;//从下一行的第0列开始
                    break;
                }
                j++;
            }
            if(queueArr[i] == initVal){
                //代表第i行不能放置皇后
                //需要回溯
                if(i == 0){
                    //表示无法再回溯
                    break;
                }else{
                    i--;
                    j = queueArr[i] + 1;
                    queueArr[i] = initVal;
                    continue;
                }
            }
            if(i == n -1){
                //找到解
                List<String> list = new ArrayList<>();
                for(int k = 0; k < n; k++){
                    StringBuffer sb = new StringBuffer();
                    for(int l = 0; l < n; l++){
                        if(queueArr[k] == l){
                            sb.append("Q");
                        }else {
                            sb.append(".");
                        }
                    }
                    list.add(sb.toString());
                }
                retList.add(list);
                j = queueArr[i] + 1;
                queueArr[i] = initVal;
                continue;
            }
            i++;
        }

        return retList;
    }
}
