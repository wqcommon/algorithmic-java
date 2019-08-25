package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wenqiang
 * @date: 2019-08-25 16:04
 *
 * 66. 二叉树的前序遍历
 */
public class Alg66 {

    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        //非递归
        List<Integer> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node  = stack.pop();
            retList.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
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
