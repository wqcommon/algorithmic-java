package com.algorithmic.datastructure.queue;

/**
 * @author qiang.wen
 * @date 2018/8/30 16:38
 *
 * 问题描述：给出一串整数流和窗口大小，计算滑动窗口中所有整数的平均值。
 *
 * 样例：
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1 // 返回 1.00000
 * m.next(10) = (1 + 10) / 2 // 返回 5.50000
 * m.next(3) = (1 + 10 + 3) / 3 // 返回 4.66667
 * m.next(5) = (10 + 3 + 5) / 3 // 返回 6.00000
 */
public class MovingAverageFromDataStream {

    public static void main(String[] args) {

    }

    private int cap;

    private int count;

    private QNode head;

    private QNode tail;

    private static class QNode{
        int val;
        QNode next;

        QNode(int val){
            this.val = val;
        }
    }


    public MovingAverageFromDataStream(int size) {
        // do intialization if necessary
        this.cap = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        //加入到队列中
        QNode node = new QNode(val);
        if(head == null){
            head = tail = node;
            count += 1;
        }else if(count < cap){
            tail.next = node;
            tail = node;
            count += 1;
        }else {
            head = head.next;
            tail.next = node;
            tail = node;
        }
        double sum = 0;
        QNode tNode = head;
        while (tNode != null){
            sum += tNode.val;
            tNode = tNode.next;
        }
        return sum/count;

    }


}
