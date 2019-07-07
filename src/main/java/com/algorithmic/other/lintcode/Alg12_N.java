package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-06 20:17
 * 12. 带最小值操作的栈
 *
 * 比较复杂的一种解决方案，时间复杂度不是O(1)
 * 没有考虑到当当前值比最小值大的时候，最小值还是原来的值的这个点，导致设计复杂了
 */
public class Alg12_N {

    public static void main(String[] args) {

    }

    public class MinStack {

        public Node head; //栈的头节点

        public MinNode minHead;//最小值的头节点

        class Node{
            int val;
            Node next;

            public Node(int val){
                this.val = val;
            }
        }

        class MinNode{
            int val;
            MinNode pre;
            MinNode next;
            public MinNode(int val){
                this.val = val;
            }
        }

        public MinStack() {
            // do intialization if necessary
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(Integer number) {
            // write your code here
            Node node = new Node(number);
            //元素入栈
            if(head == null){
                head = node;
            }else{
                node.next = head;
                head = node;
            }
            //插入最小值节点
            MinNode minNode = new MinNode(number);
            if(minHead == null){
                minHead = minNode;
            }else {
                if(number <= minHead.val){
                    minNode.next = minHead;
                    minHead.pre = minNode;
                    minHead = minNode;
                }else{
                    MinNode pre = minHead;
                    MinNode cur = pre.next;
                    while (cur != null && number > cur.val){
                        pre = cur;
                        cur = cur.next;
                    }
                    if(cur == null){
                        pre.next = minNode;
                        minNode.pre = pre;
                    }else{
                        pre.next = minNode;
                        minNode.next = cur;
                        cur.pre = minNode;
                        minNode.pre = pre;
                    }
                }
            }
        }

        /*
         * @return: An integer
         */
        public Integer pop() {
            // write your code here
            if(head == null){
                return null;
            }
            Integer val = head.val;
            head = head.next;

            //删除最小值节点
            MinNode cur = minHead;
            while (val != cur.val){
                cur = cur.next;
            }
            if(cur.pre == null){
                //head节点
                minHead = cur.next;
                if(minHead != null){
                    minHead.pre = null;
                }
            }else if(cur.next == null){
                cur.pre.next = null;
                cur.pre = null;
            }else{
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
            }

            return val;
        }

        /*
         * @return: An integer
         */
        public Integer min() {
            // write your code here
            if(minHead == null){
                return null;
            }
            return minHead.val;
        }
    }
}
