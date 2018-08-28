package com.algorithmic.datastructure.linkedlist;

/**
 * @author qiang.wen
 * @date 2018/8/28 20:39
 *
 * 判断链表是否有环
 *
 * 描述：给定一个链表，判断它是否有环。
 *
 * 例如：给出 -21->10->4->5, tail connects to node index 1，返回 true
 *
 * 挑战：不要使用额外的空间
 */
public class LinkedListCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        // write your code here

        return false;
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
