package com.algorithmic.other.lintcode;


import java.util.List;

/**
 * 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
 *
 *
 */
public class Alg391 {


    /**
     * 方法一：构造一个数组存放每一时刻的飞机数量
     *
     * @param airplanes
     * @return
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        int nMin = Integer.MAX_VALUE;
        int nMax = Integer.MIN_VALUE;
        for(Interval interval: airplanes){
            if(interval.start < nMin){
                nMin = interval.start;
            }
            if(interval.end > nMax){
                nMax = interval.end;
            }
        }
        int[] airSizeArr = new int[nMax - nMin];
        int maxCount = 0;
        for(Interval interval : airplanes){
            for(int s = interval.start; s < interval.end; s++){
                airSizeArr[s - nMin]++;
                if(airSizeArr[s - nMin] > maxCount){
                    maxCount = airSizeArr[s - nMin];
                }
            }
        }
        return maxCount;
    }

    /**
     * 方法二：构造一个数组，用于记录某一个时刻飞机起飞和降落的情况，起飞数量加1，降落数量减1
     * @param airplanes
     * @return
     */
    public int countOfAirplanes2(List<Interval> airplanes) {
        // write your code here
        int nMin = Integer.MAX_VALUE;
        int nMax = Integer.MIN_VALUE;
        for(Interval interval: airplanes){
            if(interval.start < nMin){
                nMin = interval.start;
            }
            if(interval.end > nMax){
                nMax = interval.end;
            }
        }
        int[] airSizeArr = new int[nMax - nMin + 1];
        for(Interval interval : airplanes){
            airSizeArr[interval.start - nMin]++;
            airSizeArr[interval.end - nMin]--;
        }
        int maxCount = 0;
        int curSum = 0;
        for(int i : airSizeArr){
            curSum += i;
            if(curSum > maxCount){
                maxCount = curSum;
            }
        }
        return maxCount;
    }

    static class Interval {
     int start, end;
     Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }
  }


}
