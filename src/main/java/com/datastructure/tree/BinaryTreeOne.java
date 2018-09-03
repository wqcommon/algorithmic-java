package com.datastructure.tree;

/**
 * @author qiang.wen
 * @date 2018/9/3 20:42
 *
 * 二叉树的存储实现：数组实现
 *
 * 备注：
 * 1、 第i个结点的左孩子结点为2*i,右孩子结点为2*i+1; i>=1
 * 2、对于查询某个结点的孩子结点或者双亲结点很方便
 *
 *  这种用数组顺序存储的方式比较适合完全二叉树，当树为右斜树或左斜树（结点只有右子节点或左子结点），这种方式会造成很大的空间浪费（有一半空间浪费了）
 *
 */
public class BinaryTreeOne {

    //数组实现
    private TreeNode[] nodes;

    public BinaryTreeOne(int size){
        nodes = new TreeNode[size];
    }

    private static class TreeNode{

        private Object data;

    }
}
