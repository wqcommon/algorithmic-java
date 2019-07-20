package com.algorithmic.other.lintcode;

import java.util.*;

/**
 * @author: wenqiang
 * @date: 2019-07-13 16:33
 *
 * 20. 骰子求和
 * 扔 n 个骰子，向上面的数字之和为 S。给定 n，请列出所有可能的 S 值及其相应的概率。
 */
public class Alg20 {

    public static void main(String[] args) {
        new Alg20().dicesSum(9);
    }

    /**
     * 动态规划
     * 解题思路：
     * 1、用一个二维数组dp[i][j]来表示i个骰子得到j的情况的个数，例：dp[2][3]:2个骰子摇出3的有多少种情况
     * 2、对于dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3] + dp[i-1][j-4] + dp[i-1][j-5] + dp[i-1][j-6]
     * @param n
     * @return
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> retList = new ArrayList<>();
        if (n <= 0){
            return retList;
        }
        long[][] coutArr = new long[n + 1][6 * n + 1];
        coutArr[1][1] = coutArr[1][2] = coutArr[1][3] = coutArr[1][4] = coutArr[1][5] = coutArr[1][6] = 1;
        for(int i = 2; i <= n; i++){
            for (int j = i; j <= i * 6; j++){
                long tmp = 0;
                if(j - 1 > 0){
                    tmp += coutArr[i - 1][j - 1];
                }
                if(j - 2 > 0){
                    tmp += coutArr[i - 1][j - 2];
                }
                if(j - 3 > 0){
                    tmp += coutArr[i - 1][j - 3];
                }
                if(j - 4 > 0){
                    tmp += coutArr[i - 1][j - 4];
                }
                if(j - 5 > 0){
                    tmp += coutArr[i - 1][j - 5];
                }
                if(j - 6 > 0){
                    tmp += coutArr[i - 1][j - 6];
                }
                coutArr[i][j] = tmp;
            }
        }
        double count = Math.pow(6,n);
        for(int m = n; m <= 6 * n; m++){
            Map.Entry<Integer, Double> entry = new AbstractMap.SimpleEntry<>(m,coutArr[n][m]/count);
            retList.add(entry);
        }

        return retList;
    }


    /**
     * 递归的做法，最low的做法，有可能会超出内存限制
     * @param n
     * @return
     */
    public List<Map.Entry<Integer, Double>> dicesSum2(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> retList = new ArrayList<>();
        if (n <= 0){
            retList.add(null);
            return retList;
        }
        Map<Integer,Integer> countMap = new HashMap<>();
        recurse(n,0,countMap);
        //求出总数
        double count = 0;
        for(Iterator<Integer> it = countMap.values().iterator();it.hasNext();){
            count += it.next();
        }
        for(Iterator<Integer> it = countMap.keySet().iterator();it.hasNext();){
            int key = it.next();
            int num = countMap.get(key);
            Map.Entry<Integer, Double> entry = new AbstractMap.SimpleEntry<>(key,num / count);
            retList.add(entry);
        }
        return retList;
    }

    private void recurse(int n,int val, Map<Integer, Integer> countMap) {
        if(n == 0){
            Integer cout = countMap.get(val);
            if(cout == null){
                cout = 1;
            }else {
                cout += 1;
            }
            countMap.put(val,cout);
            return;
        }
        for(int i = 1; i <= 6; i++){
            recurse(n - 1,val + i,countMap);
        }
    }



}
