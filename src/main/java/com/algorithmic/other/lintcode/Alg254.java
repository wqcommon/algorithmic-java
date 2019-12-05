package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-12-03 20:42
 * 丢鸡蛋
 */
public class Alg254 {

    /**
     * 实现思路：
     * 两个鸡蛋
     * 假设最差需要n次，那么第1次是从第n层往下扔，如果此时鸡蛋碎了，那么就需要用另一个鸡蛋从第一层开始一层一层试，最差需要n次
     * 如果鸡蛋没碎，那么接下来再网上n-1层，依次类推，直到等于1
     * @param n
     * @return
     */
    public int dropEggs(int n) {
        // write your code here
        long sum = 0;
        for(int i = 1;;i++){
            sum += i;
            if(sum >= n){
                return i;
            }
        }
    }
}
