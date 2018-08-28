package com.algorithmic.datastructure.linkedlist;

/**
 * @author qiang.wen
 * @date 2018/8/28 15:41
 *
 * 问题描述：翻转一个链表
 *
 * 例如：给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 *
 * 挑战：在原地一次翻转完成
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ReverseLinkedList().new ListNode(0);
        ListNode listNode1 = new ReverseLinkedList().new ListNode(1);
        listNode.next = listNode1;
        ListNode retNode = new ReverseLinkedList().reverse(listNode);
    }


    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
