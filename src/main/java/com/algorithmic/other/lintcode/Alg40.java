package com.algorithmic.other.lintcode;

import java.util.Stack;

/**
 * @author: wenqiang
 * @date: 2019-07-20 21:01
 *
 * 40. 用栈实现队列
 * 正如标题所述，你需要使用两个栈来实现队列的一些操作。
 *
 * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
 *
 * pop和top方法都应该返回第一个元素的值。
 *
 *
 * 考虑了性能的解决方案
 */
public class Alg40 {

    public class MyQueue {

        private Stack<Integer> pushStack;

        private Stack<Integer> popStack;

        public MyQueue() {
            // do intialization if necessary
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
           pushStack.push(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            if(popStack.isEmpty()){
                //把pushStack的值全部倒过来
                while (!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            if(popStack.isEmpty()){
                //把pushStack的值全部倒过来
                while (!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }
    }
}
