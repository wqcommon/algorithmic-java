package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-11-24 16:29
 */
public class A_2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = null;
        ListNode retNode = null;
        boolean jw = false; //是否需要进位
        while (l1 != null || l2 != null){
            int lv1 = l1 == null ? 0:l1.val;
            int lv2 = l2 == null ? 0:l2.val;
            //对val的处理
            int val = 0;
            if(jw){
                if(lv1 + lv2 + 1 >= 10){
                    val = (lv1 + lv2 + 1) - 10;
                    jw = true;
                }else {
                    val = lv1 + lv2 + 1;
                    jw = false;
                }

            }else {
                if(lv1 + lv2  >= 10){
                    val = (lv1 + lv2) - 10;
                    jw = true;
                }else {
                    val = lv1 + lv2;
                    jw = false;
                }
            }
            //结果封装
            ListNode node = new ListNode(val);
            if(retNode == null){
                retNode = pre = node;
            }else {
                pre.next = node;
                pre = node;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(jw){
            ListNode node = new ListNode(1);
            pre.next = node;
        }
        return retNode;
    }
}
