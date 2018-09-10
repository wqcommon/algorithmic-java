package com.datastructure.tree.algorithmic;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/9/4 11:05
 *
 * 二叉树的层序遍历
 *
 * 规则：从根节点开始，先访问根节点，逐层访问，同一层按照从左往右的顺序访问
 */
public class BinaryTreeSeqTraversing {


    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");

        A.left = B;
        A.right = C;
        B.left = D;
        C.left = E;
        C.right = F;
        D.left = G;
        D.right = H;
        E.right = I;

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(A);
//        traversingByRecursive(nodes);
        try {
            traversingByQueue(A);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过递归遍历整颗树
     * @param nodes
     */
    private static void traversingByRecursive(List<TreeNode> nodes){
        if(nodes == null || nodes.size() == 0){
            return;
        }
        final List<TreeNode> childNodes = new ArrayList<>();
        nodes.forEach(node ->{
            System.out.print(node.data + ",");
            if(node.left != null){
                childNodes.add(node.left);
            }
            if(node.right != null){
                childNodes.add(node.right);
            }
        });
       traversingByRecursive(childNodes);
    }

    /**
     * 通过使用队列来实现遍历整棵树
     *
     * 符合先进先出的原则（FIFO）
     */
    private static void traversingByQueue(TreeNode root) throws InterruptedException {
        if(root == null){
            return;
        }
        Queue<TreeNode> nodeQueue = new Queue<>();
        nodeQueue.enqueue(root);
        while (!nodeQueue.isEmpty()){
            //出列
            TreeNode node = nodeQueue.dequeue();
            System.out.print(node.data);
            //左右孩子入列
            if(node.left != null){
                nodeQueue.enqueue(node.left);
            }
            if(node.right != null){
                nodeQueue.enqueue(node.right);
            }
        }

    }


    private static class TreeNode{

        private String data;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(String data){
            this.data = data;
        }
    }
}
