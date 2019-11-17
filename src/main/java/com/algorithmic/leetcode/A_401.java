package com.algorithmic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-11-17 15:13
 *  二进制手表
 */
public class A_401 {
    List<String> ret =  new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        if(num <= 0){
            ret.add("0:00");
            return ret;
        }
        //规则 小时(0-11),分钟(0-59)
        int[] visted = new int[10];//标记是否包含
        recure(0,0,num,visted);
        return ret;
    }

    private void recure(int start, int count, int num, int[] visted) {
        if(count == num){
            int hour = visted[0] * 1 + visted[1] * 2 + visted[2] * 4 + visted[3]*8;
            int minute = visted[4] * 1 + visted[5] * 2 + visted[6] * 4 + visted[7] * 8 + visted[8] * 16 + visted[9] * 32;
            if(hour < 12 && minute < 60){
                ret.add(String.format("%d:%02d",hour,minute));
            }
            return;
        }
        for(int i = start; i <= 10 - (num - count); i++){
            //10-(num - count) 表示i能够在的最大位置
            visted[i] = 1;
            recure(i+1,count+1,num,visted);
            visted[i] = 0;
        }
    }

}
