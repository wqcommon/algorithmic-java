package com.algorithmic.datastructure.tree.binaryTree;

import java.util.Stack;

/**
 * @author qiang.wen
 * @date 2018/8/29 16:28
 *  DFS遍历（Depth-First-Search,深度遍历搜索） 包含：前序、中序、后序遍历
 *  BFS遍历（Breadth-First-Search,广度遍历搜索）
 *  二叉树的遍历
 */
public class BinaryTreeTraver {

    public static void main(String[] args) {
        TreeNode n1 = new BinaryTreeTraver().new TreeNode(4);
        TreeNode n2 = new BinaryTreeTraver().new TreeNode(2);
        TreeNode n3 = new BinaryTreeTraver().new TreeNode(5);
        TreeNode n4 = new BinaryTreeTraver().new TreeNode(1);
        TreeNode n5 = new BinaryTreeTraver().new TreeNode(3);
        TreeNode n6 = new BinaryTreeTraver().new TreeNode(7);
        TreeNode n7 = new BinaryTreeTraver().new TreeNode(8);
        TreeNode n8 = new BinaryTreeTraver().new TreeNode(9);
        TreeNode n9 = new BinaryTreeTraver().new TreeNode(10);
        TreeNode n10 = new BinaryTreeTraver().new TreeNode(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n5.right = n7;
        n3.left = n8;
        n3.right = n9;
        n9.right = n10;
//        new BinaryTreeTraver().midIterator(n1);
        new BinaryTreeTraver().midIteratorByStack(n1);
    }


    /**
     * 中序遍历
     *
     * 基于递归
     */
    public void midIterator(TreeNode root){
        if(root.left == null && root.right == null){
            System.out.print(root.val + ",");
            return;
        }
        if(root.left != null){
            midIterator(root.left);
        }
        System.out.print(root.val + ",");
        if(root.right != null){
            midIterator(root.right);
        }
    }

    /**
     * 中序遍历
     * 非递归
     * 使用栈实现
     * @param root
     */
    public void midIteratorByStack(TreeNode root){
        //使用栈实现
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        //从root节点及root的左树入栈
        //不是很优雅的方式实现
//        lable:
//        while (true){
//            while (true){
//                //入栈
//                if(node == null){
//                    break;
//                }
//                stack.add(node);
//                node = node.left;
//            }
//            //出栈
//            while (true){
//                if(stack.size() == 0){
//                    break lable;
//                }
//                TreeNode popNode = stack.pop();
//                System.out.println(popNode.val);
//                if(popNode.right != null){
//                    node = popNode.right;
//                    continue lable;
//                }
//            }
//        }

        //比较好的方式实现
        while (node != null || !stack.isEmpty()){

            while (node != null){
                //入栈
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                TreeNode n = stack.pop();
                System.out.println(n.val);
                node = n.right;
            }
        }

    }





    private class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }
}
