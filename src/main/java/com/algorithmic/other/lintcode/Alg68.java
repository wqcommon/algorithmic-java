package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wenqiang
 * @date: 2019-08-25 16:56
 *
 * 二叉树的后序遍历
 * 给出一棵二叉树，返回其节点值的后序遍历。
 *
 *
 */
public class Alg68 {

    public List<Integer> postorderTraversal(TreeNode root) {

        /**
         * 每个元素都会遍历2次
         * 需要保证第一次遍历的时候不弹出，第二次遍历的时候弹出
         * curr.left == pre 这是第一次遍历
         *
         */
        // write your code here
        List<Integer> retList = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode curr = null;
            TreeNode pre = null;
            while (!stack.isEmpty()){
                curr = stack.peek();
                if(pre == null || pre.left == curr || pre.right == curr){
                    if(curr.left != null){
                        stack.push(curr.left);
                    }else if(curr.right != null){
                        stack.push(curr.right);
                    }
                }else if (curr.left == pre){
                    if(curr.right != null){
                        stack.push(curr.right);
                    }
                }else {
                    retList.add(curr.val);
                    stack.pop();
                }

                pre = curr;
            }
        }

        return retList;
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
