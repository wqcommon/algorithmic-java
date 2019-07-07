package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wenqiang
 * @date: 2019-07-06 18:09
 *
 * 11. 二叉查找树中搜索区间
 * 给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值。
 */
public class Alg11 {


    //非递归方式
    public List<Integer> searchRange2(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> rets = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            //初始化stack
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node.val > k2) break;
                if(node.val >= k1 && node.val <= k2){
                    rets.add(node.val);
                }
                node = node.right;
                while (node != null){
                    stack.push(node);
                    node = node.left;
                }

            }

        }
        return rets;
    }

    //递归方式
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> rets = new ArrayList<>();
        if(root != null){
            recursive(root,k1,k2,rets);
        }
        return rets;
    }


    public void recursive(TreeNode root, int k1, int k2,List<Integer> rets){
        if(root == null) return;
        //二叉树的中序遍历
        recursive(root.left,k1,k2,rets);
        if(root.val > k2) return;
        if(root.val >= k1 && root.val <= k2){
            rets.add(root.val);
        }
        recursive(root.right,k1,k2,rets);
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
