package com.datastructure.tree;

/**
 * @author qiang.wen
 * @date 2018/9/3 20:50
 *
 * 二叉树的实现：采用链表的方式实现
 *
 * 备注：
 * 1、采用链表的方式适合所有的二叉树
 * 2、这种实现的方式很容易能够得到某个结点的左右孩子结点，而且也省空间（按需分配空间）
 * 3、这种方式存在一个问题，如果需要获取双亲结点，需要遍历，解决该问题的方式，给结点添加一个字段表示双亲结点
 *
 *
 */
public class BinaryTreeTwo {

    private TreeNode root;


    private static class TreeNode{

        private TreeNode parent;//双亲结点，root的双亲结点为null

        private Object data;

        private TreeNode left;

        private TreeNode right;
    }
}
