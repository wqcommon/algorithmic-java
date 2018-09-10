package com.datastructure.tree.binaryTree;

/**
 * @author qiang.wen
 * @date 2018/9/3 15:02
 *
 * 树的实例一：
 *
 * 以双亲表示法为基础构造树的实现
 *
 * 从双亲的角度来构造
 */
public class TreeInstanceOne {


    //利用数组来存储结点
    private TreeNode[] nodes = new TreeNode[Integer.MAX_VALUE];

    private int rootNodeIdx;//根结点的索引

    private int nodeCount;//当前树的结点总数

    /**
     * 树的结点
     */
    private static class TreeNode{

        private Object data;//数据项

        private int parent;//双亲结点的索引，根节点的双亲结点索引为-1

        private int firstChild;//当前结点的第一个孩子结点，不存在的索引为-1

        private int sublingChild;//当前节点的右兄弟结点，不存在的索引为-1

    }
}


/**
 *
 * 只存储了parent的树的表示，有如下特点：
 * 1、能够很快的查找到某个节点的双亲结点，时间复杂度：O(1)
 * 问题：
 * 1、想知道某个节点的孩子节点需要遍历整棵树
 *
 * 解决方案：给每个结点添加一个字段用于存储当前结点的第一个孩子节点
 *
 * 问题：
 * 1、当想知道某个结点的兄弟节点，同样需要遍历整颗树
 *
 * 解决方案：给每个结点添加一个字段用于存储当前节点的右兄弟节点
 *
 */