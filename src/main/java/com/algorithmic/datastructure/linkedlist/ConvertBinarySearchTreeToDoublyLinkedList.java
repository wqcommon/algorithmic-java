package com.algorithmic.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qiang.wen
 * @date 2018/8/29 16:42
 *
 * 将二叉查找树转换成双链表
 * 问题描述：将一个二叉查找树按照中序遍历转换成双向链表。
 * 例如：给定一个二叉查找树：
 *     4
 *    / \
 *   2   5        结果为：1<->2<->3<->4<->5
 *  /  \
 *  1  3
 */
public class ConvertBinarySearchTreeToDoublyLinkedList {


    public static void main(String[] args) {

        TreeNode n1 = new ConvertBinarySearchTreeToDoublyLinkedList().new TreeNode(4);
        TreeNode n2 = new ConvertBinarySearchTreeToDoublyLinkedList().new TreeNode(2);
        TreeNode n3 = new ConvertBinarySearchTreeToDoublyLinkedList().new TreeNode(5);
        TreeNode n4 = new ConvertBinarySearchTreeToDoublyLinkedList().new TreeNode(1);
        TreeNode n5 = new ConvertBinarySearchTreeToDoublyLinkedList().new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

//        DoublyListNode node = new ConvertBinarySearchTreeToDoublyLinkedList().bstToDoublyList(n1);
        DoublyListNode node = new ConvertBinarySearchTreeToDoublyLinkedList().bstToDoublyListByStack(n1);
        System.out.println(node);
    }

    /**
     * 借助了一个list集合
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }

        List<TreeNode> retNodes = new ArrayList<>();
        traverTreeNode(root,retNodes);
        DoublyListNode head = new DoublyListNode(retNodes.get(0).val);
        DoublyListNode prev = head;
        if(retNodes.size() == 1){
            return head;
        }
        for(int i = 1; i < retNodes.size(); i++){
            DoublyListNode node = new DoublyListNode(retNodes.get(i).val);
            prev.next = node;
            node.prev = prev;
            prev = node;
        }
        return head;
    }

    /**
     * 对TreeNode进行中序遍历，得到一个列表
     * @param root
     * @param retNodes
     */
    private void traverTreeNode(TreeNode root,List<TreeNode> retNodes){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            retNodes.add(root);
            return;
        }
        if(root.left != null){
            traverTreeNode(root.left,retNodes);
        }
        retNodes.add(root);
        if(root.right != null){
            traverTreeNode(root.right,retNodes);
        }
    }


    /**
     * 使用非递归的方式实现
     * @param root
     * @return
     */
    public DoublyListNode bstToDoublyListByStack(TreeNode root) {
        if(root == null){
            return null;
        }
        DoublyListNode head = null;
        DoublyListNode tail = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){

            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                DoublyListNode listNode = new DoublyListNode(node.val);
                if(head == null){
                    head = tail = listNode;
                }else {
                    tail.next = listNode;
                    listNode.prev = tail;
                    tail = listNode;
                }
                root = node.right;
            }
        }
        return head;
    }

    private class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }

    private class DoublyListNode {
      int val;
      DoublyListNode next, prev;
      DoublyListNode(int val) {
          this.val = val;
          this.next = this.prev = null;
      }
    }
}
