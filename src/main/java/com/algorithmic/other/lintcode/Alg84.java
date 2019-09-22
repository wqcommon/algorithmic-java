package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-09-22 19:38
 * 84. 落单的数 III
 * 给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字。
 */
public class Alg84 {

    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> retList = new ArrayList<>();
        if(A == null || A.length == 0){
            return retList;
        }
        int xor = 0;
        for(int i = 0; i < A.length; i++){
            xor ^= A[i];
        }
        int lastBit = xor & (-xor); //获取最后一位为1的数据
        //通过这个1能够将数据分成2部分，一部分在该位上为0，另一部分在该位上为1
        int g1 = 0,g2 = 0;
        for(int i = 0; i< A.length; i++){
            if((A[i] & lastBit) == 0){
                g1 ^= A[i];
            }else {
                g2 ^= A[i];
            }
        }
        retList.add(g1);
        retList.add(g2);
        return retList;
    }
}
