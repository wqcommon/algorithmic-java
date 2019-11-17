package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-11-10 19:24
 *
 * 加油站
 */
public class A_134 {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0; //总剩余油量
        int currGas = 0; // 当前剩余油量
        int start = 0; //开始位置
        for(int i = 0; i < gas.length;i++){
            totalGas += gas[i] - cost[i];
            currGas += gas[i] - cost[i];
            if(currGas < 0){
                currGas = 0;
                start = i + 1;
            }
        }
        return totalGas < 0 ? -1 : start;

    }


    public int canCompleteCircuitI(int[] gas, int[] cost) {
//        int last = 0;
//        for(int i = 0; i < gas.length; i++){
//            last += gas[i] - cost[i];
//        }
//        if(last < 0){
//            return -1;
//        }
        for(int s = 0; s < gas.length; s++){
            if(gas[s] - cost[s] >= 0){
                int j = s;
                int leave = gas[j] - cost[j];
                int idx = j+1 == gas.length ? 0 : j+1;
                while (idx != j){
                    leave += gas[idx] - cost[idx];
                    if(leave < 0){
                        break;
                    }
                    idx++;
                    if(idx == gas.length){
                        idx = 0;
                    }
                }
                if(idx == j){
                    return s;
                }

            }
        }
        return  -1;

    }
}
