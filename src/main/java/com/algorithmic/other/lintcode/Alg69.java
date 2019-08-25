package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wenqiang
 * @date: 2019-08-25 18:42
 *
 * 69. 二叉树的层次遍历
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 *
 * 挑战
 * 挑战1：只使用一个队列去实现它
 * 挑战2：用BFS算法来做
 */
public class Alg69 {


    /**
     * 方法一：通过层级的开始节点来分层
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> retList = new ArrayList<>();
        if(root != null){
            Queue<TreeNode> queue =  new LinkedList<>();
            TreeNode levelFirstNode = null;
            queue.add(root);
            List<Integer> levelList = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node == levelFirstNode){
                    retList.add(levelList);
                    levelFirstNode = null;
                    //构造层级list
                    levelList = new ArrayList<>();
                }
                //设置层级第一个Node
                if(levelFirstNode == null && node.left != null){
                    levelFirstNode = node.left;
                }else if (levelFirstNode == null && node.right != null){
                    levelFirstNode = node.right;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                levelList.add(node.val);
            }
            retList.add(levelList);
        }
        return retList;
    }

    /**
     * 方法二：根据每层的元素个数来遍历；和方法一思路差不多，但是更简单明了
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        // write your code here
        List<List<Integer>> retList = new ArrayList<>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size =  queue.size();
                List<Integer> ret = new ArrayList<>();
                while (--size >= 0){
                    TreeNode node = queue.poll();
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                    ret.add(node.val);
                }
                retList.add(ret);
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
