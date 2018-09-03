package com.algorithmic.datastructure.stack.base;

/**
 * @author qiang.wen
 * @date 2018/8/29 20:35
 *
 * 双向链表实现的栈
 *
 */
public class StackByDoublyLinkedList {


    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Integer val = null;
        while ((val = stack.pop()) != null){
            System.out.print(val + ",");
        }

    }

    private static class Stack{

        private SNode head;


        public Stack(){

        }

        public void push(int val){
            SNode node = new SNode(val);
            if(head == null){
                head = node;
            }else{
                head.next = node;
                node.prev = head;
                head = node;
            }
        }

        public Integer pop(){
            if(head == null){
               return null;
            }
            int val = head.val;
            head = head.prev;
            return val;
        }

    }

    private static class SNode{

        int val;

        SNode next;

        SNode prev;

        public SNode(int val){
            this.val = val;
        }

    }
}
