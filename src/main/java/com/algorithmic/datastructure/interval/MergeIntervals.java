package com.algorithmic.datastructure.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/8/27 11:21
 *
 * 问题描述：给出若干闭合区间，合并所有重叠的部分。
 *
 * 例子：[                     [
 *           (1, 3),               (1, 6),
 *           (2, 6),      =>       (8, 10),
 *           (8, 10),              (15, 18)
 *           (15, 18)            ]
        ]
 *
 * 挑战：O(n log n) 的时间和 O(1) 的额外空间
 */
public class MergeIntervals {

    public static void main(String[] args) {



    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0){
            return intervals;
        }
        // write your code here
        Interval[] sourceArr = new Interval[intervals.size()];
        intervals.toArray(sourceArr);
        heapSort(sourceArr);
        //合并
        List<Interval> retIntervals = new ArrayList<>();
        int startIdx = 0;
        for (int i = 0; i < sourceArr.length; i++){
            if(sourceArr[startIdx].end >= sourceArr[i].start){
                sourceArr[startIdx].end = Math.max(sourceArr[startIdx].end,sourceArr[i].end);
            }else {
                retIntervals.add(sourceArr[startIdx]);
                startIdx = i;
            }
        }
        retIntervals.add(sourceArr[startIdx]);
        return retIntervals;
    }

    private void heapSort(Interval[] sourceArr) {
        makeHeap(sourceArr,sourceArr.length);
        for(int i = sourceArr.length -1; i > 0; i--){
            Interval temp = sourceArr[i];
            sourceArr[i] = sourceArr[0];
            sourceArr[0] = temp;
            makeHeap(sourceArr,i);
        }
    }

    private void makeHeap(Interval[] sourceArr,int len){
        for(int i = len/2 - 1; i >= 0; i--){
            int j = 2 * i + 1;
            if(j < len){
                if(j + 1 < len && sourceArr[j].start < sourceArr[j +1].start){
                   j += 1;
                }
                if(sourceArr[i].start < sourceArr[j].start){
                    Interval temp = sourceArr[j];
                    sourceArr[j] = sourceArr[i];
                    sourceArr[i] = temp;
                }
            }

        }
    }

    private class Interval{
        int start,end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

}
