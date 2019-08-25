package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wenqiang
 * @date: 2019-08-25 16:15
 *
 * 67. 二叉树的中序遍历
 *
 */
public class Alg67 {

    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> retList = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            //init
            TreeNode nodeLeft = root;
            while (nodeLeft != null){
                stack.push(nodeLeft);
                nodeLeft = nodeLeft.left;
            }
            while (!stack.isEmpty()){
                TreeNode node  = stack.pop();
                retList.add(node.val);
                TreeNode nodeRight = node.right;
                while (nodeRight != null){
                    stack.push(nodeRight);
                    nodeRight = nodeRight.left;
                }
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
