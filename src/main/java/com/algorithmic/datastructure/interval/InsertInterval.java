package com.algorithmic.datastructure.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/8/23 9:47
 * 插入区间
 *
 * 描述：Given a non-overlapping interval list which is sorted by start point.
 * Insert a new interval into it,
 * make sure the list is still in order and non-overlapping (merge intervals if necessary)
 * 中文描述：
 * 给定一个非重叠的区间列表，它按起点排序；在其中插入一个新的区间，确保列表仍然有序且不重叠（必要时合并区间）
 *
 * 例如：把(2, 5) 插入到 [(1,2), (5,9)], 结果为： [(1,9)].
 *      把 (3, 4) 插入到 [(1,2), (5,9)], 结果为：[(1,2), (3,4), (5,9)].
 */
public class InsertInterval {


    /**
     * 这个类表示区间，例如：(2,5) 2-5
     */
    private static class Interval{
        int start,end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 插入区间
     * @param intervals
     * @param newInstance
     * @return
     */
    private static List<Interval> insert(List<Interval> intervals,Interval newInstance){
        List<Interval> retIntervals = new ArrayList<>();
        int insertPos = 0;
        for(Interval curr : intervals){
            if(curr.end < newInstance.start){
                retIntervals.add(curr);
                insertPos ++;
            }else if(curr.start > newInstance.end){
                retIntervals.add(curr);
            }else{
                newInstance.start = Math.min(newInstance.start,curr.start);
                newInstance.end = Math.max(newInstance.end,curr.end);
            }
        }
        retIntervals.add(insertPos,newInstance);
        return retIntervals;
    }

    /**
     * 插入区间
     * @param intervals
     * @param newInterval
     * @return
     */
    private static List<Interval> insertTwo(List<Interval> intervals,Interval newInterval){

        List<Interval> retIntervals = new ArrayList<>();
        int insertPos = 0;
        while (insertPos < intervals.size() && intervals.get(insertPos).start < newInterval.start){
            insertPos ++;
        }
        intervals.add(insertPos,newInterval);
        Interval last = null;
        for(Interval curr : intervals){
            if(last == null || last.end < curr.start){
                retIntervals.add(curr);
                last = curr;
            }else{
                last.end = Math.max(last.end,curr.end);
            }
        }
        return retIntervals;

    }

}


