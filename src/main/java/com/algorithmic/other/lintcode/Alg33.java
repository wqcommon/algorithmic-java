package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 * n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
 * 给定一个整数n，返回所有不同的n皇后问题的解决方案。
 *
 * 思路：
 * 1、要满足不能皇后不能在同行、同列、两条斜线
 * 2、然后我们按照上面的规则来分配每一列的解，每一列的解从1-n依次判断，满足条件就分配。
 * 3、属于DFS（广度遍历优先）问题
 */
public class Alg33 {

    public List<List<String>> solveNQueens(int n) {
      return null;
    }
}
