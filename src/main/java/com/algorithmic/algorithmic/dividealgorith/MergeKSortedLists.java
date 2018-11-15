package com.algorithmic.algorithmic.dividealgorith;

import java.util.List;

/**
 * 描述:
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 * 样例:
 * 给出3个排序链表[2->4->null,null,-1->null]，返回 -1->2->4->null
 */
public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }
        if(lists.size() == 1){
            return lists.get(0);
        }
        ListNode[] nodes = new ListNode[lists.size()];
        int k = 0;
        for(ListNode node : lists){
            if(node != null){
                nodes[k++] = node;
            }
        }
        int tempIdx = 0;
        ListNode headNode = null,tailNode = null;
        while (k >= 1){
            //堆排序
            for(int i = k/2 -1; i >= 0; i--){
                tempIdx = 2*i + 1;
                if(2*i + 2 < k){
                    tempIdx = nodes[2*i+1].val < nodes[2*i+2].val ? 2*i+1 : 2*i + 2;
                }
                if(nodes[i].val > nodes[tempIdx].val){
                    ListNode temp = nodes[i];
                    nodes[i] = nodes[tempIdx];
                    nodes[tempIdx] = temp;
                }
            }
            ListNode temp = nodes[0];
            ListNode cNode = new ListNode(temp.val);
            if(headNode == null){
                headNode = cNode;
            }else {
                tailNode.next = cNode;
            }
            tailNode = cNode;
            nodes[0] = nodes[k-1];
            if(temp.next != null){
                nodes[k-1] = temp.next;
            }else {
                k--;
            }
        }
        return headNode;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
