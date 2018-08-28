package com.algorithmic.datastructure.linkedlist;

/**
 * @author qiang.wen
 * @date 2018/8/28 16:53
 *
 * 链表划分
 * 问题描述：给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。你应该保留两部分内链表节点原有的相对顺序。
 *
 * 例如：给定链表 1->4->3->2->5->2->null，并且 x=3 返回 1->2->2->4->3->5->null
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode n1 = new PartitionList().new ListNode(1);
        ListNode n2 = new PartitionList().new ListNode(4);
        ListNode n3 = new PartitionList().new ListNode(3);
        ListNode n4 = new PartitionList().new ListNode(2);
        ListNode n5 = new PartitionList().new ListNode(5);
        ListNode n6 = new PartitionList().new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        new PartitionList().partition(n1,3);
    }

    /**
     *
     * 丑陋版
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode leastNode = null;
        ListNode leastPre = null;

        ListNode greatestNode = null;
        ListNode greatestPre = null;
        while (head != null){
            if(head.val < x){
                if(leastNode == null){
                    leastNode = head;
                    leastPre = head;
                }else {
                    leastPre.next = head;
                    leastPre = head;
                }
            }else {
                if(greatestNode == null){
                    greatestNode = head;
                    greatestPre = head;
                }else {
                    greatestPre.next = head;
                    greatestPre = head;
                }
            }
            head = head.next;
        }
        if(leastPre != null){
            leastPre.next = null;
        }
        if(greatestPre != null){
            greatestPre.next = null;
        }
        if(leastNode != null){
            leastPre.next = greatestNode;
            return leastNode;
        }else {
            return greatestNode;
        }
    }

    /**
     * 九章算法的 精美版
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode leftDump = new ListNode(0);
        ListNode rightDump = new ListNode(0);
        ListNode left = leftDump;
        ListNode right = rightDump;
        while (head != null){
            if(head.val < x){
                left.next = head;
                left = head;
            }else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDump.next;
        return leftDump.next;

    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
}
