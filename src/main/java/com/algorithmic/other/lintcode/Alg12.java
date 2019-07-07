package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-06 20:17
 * 12. 带最小值操作的栈
 * 时间复杂度O(1)
 */
public class Alg12 {

    public static void main(String[] args) {

    }

    public class MinStack {

        public Node head; //栈的头节点

        public Node minHead;//最小值的头节点

        class Node{
            int val;
            Node next;

            public Node(int val){
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
            if(minHead == null){
                minHead = new Node(number);
            }else{
                Integer minVal = number <= minHead.val ? number : minHead.val;
                Node curNode = new Node(minVal);
                curNode.next = minHead;
                minHead = curNode;
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
            minHead = minHead.next;
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
