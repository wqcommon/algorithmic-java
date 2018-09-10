package com.datastructure.tree.binaryTree;

/**
 * @author qiang.wen
 * @date 2018/9/4 20:07
 *
 * 线索二叉树
 *
 * 定义：指向前驱和后继的指针称为线索，加上线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树
 * 具体实现：
 * 1、把结点的右空指针指向该结点的后继
 * 2、把结点的左空指针指向该结点的前驱
 * 前驱和后继，这与以哪种次序来遍历二叉树有关，我们对二叉树以某种次序遍历使其变为线索二叉树的过程称作为线索化
 *
 * NOTE:线索化的实质就是将二叉链表中的空指针改为指向前驱或后继的线索。
 * 由于前驱 和后继的信息只有在遍历该二叉树时才能得到，所以线索化的过程就是在遍历的过程中修改空指针的过程
 *
 */
public class ThreadedBinaryTree {


    private static TreeNode head = new TreeNode(null);
    private static TreeNode pre = head;//记录之前的访问的结点



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
        TreeNode J = new TreeNode("J");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = H;
        D.right = I;
        E.left = J;
        C.left = F;
        C.right = G;

        midTraversingThreading(A);
        //head的左孩子指向根节点
        head.left = A;
        head.leftFlag = 0;
        //head的右孩子指向最后一个节点
        head.right = pre;
        head.rightFlag = 1;
        //最后一个节点指向head
        pre.right = head;
        pre.rightFlag = 1;

        //中序线索二叉树，后继遍历
//        subsequentVisit(head);
        predecessorVisit(head);
    }


    private static class TreeNode{

        private String data;

        private TreeNode left;

        private int leftFlag;//0:左孩子结点，1：前驱结点

        private TreeNode right;

        private int rightFlag;//0:右孩子结点，1：后继结点

        public TreeNode(String data){
            this.data = data;
        }
    }


    /**
     * 中序遍历线索化
     * @param root
     */
    private static void midTraversingThreading(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            midTraversingThreading(root.left);
        }
        if(root.left == null){
            root.left = pre;
            root.leftFlag = 1;
        }
        if(pre != head && pre.right == null){
            pre.right = root;
            pre.rightFlag = 1;
        }
        pre = root;
        if(root.right != null){
            midTraversingThreading(root.right);
        }

    }


    /**
     * 中序线索化------后继访问
     * @param head
     */
    private static void subsequentVisit(TreeNode head){
        //HDIBJEAFCG

        TreeNode root = head.left;
        while(root != head){

            while(root.left != null && root.leftFlag == 0){
                //左孩子节点
                root = root.left;
            }
            System.out.print(root.data);
            while (root.right != null && root.rightFlag == 1 && root.right != head){
                //访问后继结点
                root = root.right;
                System.out.print(root.data);
            }
            root = root.right;
        }

    }

    /**
     * 中序线索化----前驱访问
     * @param head
     */
    private static void predecessorVisit(TreeNode head){
        //GCFAEJBIDH
        TreeNode preNode = head.right;
        while (preNode != head){

            while (preNode.right != null && preNode.rightFlag == 0){
                preNode = preNode.right;
            }
            System.out.print(preNode.data);
            while (preNode.left != null && preNode.leftFlag == 1 && preNode.left != head){
                preNode = preNode.left;
                System.out.print(preNode.data);
            }
            preNode = preNode.left;
        }
    }

}
