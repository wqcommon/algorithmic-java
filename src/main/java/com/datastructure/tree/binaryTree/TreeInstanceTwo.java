package com.datastructure.tree.binaryTree;

/**
 * @author qiang.wen
 * @date 2018/9/3 15:24
 *
 * 树的表示法二：采用孩子表示法
 *
 * 从树的孩子角度来构造整棵树
 *
 *
 */
public class TreeInstanceTwo {

    //以数组的方式存储树的结点

    private TreeNode[] nodes = new TreeNode[Integer.MAX_VALUE];

    private int rootIdx;

    private int count;

    private static class TreeNode{

        private Object data;//数据项

        private int parent;//当前结点的双亲结点的索引

        private ChildNode firstChild;//当前结点的第一个孩子节点

    }

    private static class ChildNode{

        private int treeNodeIdx;//树结点的索引

        private ChildNode next;//某个结点的孩子节点已单向链表的方式存储
    }

}

/**
 *
 * 这种方式采用的是数组+链表的方式来实现的，用数组来存储当前树的所有结点，链表存储每个结点的孩子结点
 *
 * 这种方式的实现，有如下特点：
 * 1、能够很快的查找出某个结点的孩子结点
 * 问题：
 * 需要知道某个结点的双亲结点，需要遍历整颗树
 *
 * 解决方法：给每个结点添加一个字段用于存储双亲结点
 *
 */