package com.datastructure.tree.binaryTree;

import java.util.Stack;

/**
 * @author qiang.wen
 * @date 2018/9/10 20:11
 *
 * 二分搜索树
 */
public class BinarySearchTree<T extends Comparable<T>> {


    public static void main(String[] args) {
//        int[] values = {11,7,20,3,8,21,2}; //只有左子树
//        int[] values = {11,7,20,3,8,21,10}; //只有右子树
//        int[] values = {11,7,21,2,8,14,24,10,16,22,27}; //既有左子树又有右子树，且后继结点为叶子结点
        int[] values = {11,7,21,2,8,14,24,10,16,22,27,23};
        BinarySearchTree<Ele> tree = new BinarySearchTree<>();
        //构造树
        for(int i = 0; i < values.length; i++){
            Ele ele = new Ele(values[i]);
            tree.add(ele);
        }
        System.out.println("删除前：");
        //中序遍历
        tree.inOrderTraversal(tree.root);
        //删除值
//        tree.delete(new Ele(3)); //只有左子树
//        tree.delete(new Ele(8)); //只有右子树
//        tree.delete(new Ele(21)); //既有左子树又有右子树，且后继结点为叶子结点
//        tree.delete(new Ele(11));
        tree.delte2(new Ele(21));
        System.out.println();
        System.out.println("删除后：");
        tree.inOrderTraversal(tree.root);
    }

    private static class Node<T> {
        private T value;

        private Node<T> left;

        private Node<T> right;

        public Node(T value){
            this.value = value;
        }
    }

    private static class Ele implements Comparable<Ele>{

        private int value;

        public Ele(int value){
            this.value = value;
        }


        @Override
        public int compareTo(Ele o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    private Node<T> root;//树的根结点

    private int size;

    /**
     * 添加值
     * @param value
     * @return
     */
    public boolean add(T value){
        Node node = new Node(value);
        if(root == null){
            size ++;
            root = node;
        }else {
            insertNode(root,node);
        }
        return true;
    }

    public void insertNode(Node<T> root,Node<T> currNode){
        if(root == null || currNode == null){
            return;
        }
        if(currNode.value.compareTo(root.value) < 0){
            //左子树
            if(root.left == null){
                //左结点为空
                root.left = currNode;
            }else {
                //左结点不为空
                insertNode(root.left,currNode);
            }
        }else if(currNode.value.compareTo(root.value) > 0){
            //右子树
            if(root.right == null){
                root.right = currNode;
            }else {
                //右结点不为空
                insertNode(root.right,currNode);
            }
        }
    }

    /**
     * 删除数据 方式一
     * @param value
     * @return
     */
    public Node<T> delete(T value){
        return removeNode(root,value);
    }

    public Node<T> removeNode(Node<T> node,T value){
        if(node == null){
            return null;
        }
        if(value.compareTo(node.value) < 0){
            //左子树
            node.left = removeNode(node.left,value);
            return node;
        }else if(value.compareTo(node.value) > 0){
            //右子树
            node.right = removeNode(node.right,value);
            return node;
        }
        //当前结点是要删除的结点

        //叶子节点
        if(node.left == null && node.right == null){
            return null;
        }

        //当前结点没有右子树
        if(node.right == null){
            Node<T> leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        //当前结点没有左子树
        if(node.left == null){
            Node<T> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        //既有左子树，又有右子树,先找到该节点的后继（右子树中最小的值）或前驱（左子树中的最大值）
        Node<T> minNode = getMin(node.right);
        Node<T> rightNode = removeMin(node.right);
        minNode.left = node.left;
        minNode.right = rightNode;
        node.left = node.right = null;
        size--;
        if(node == root){
            root = minNode;
        }
        return minNode;
    }

    /**
     * 删除元素
     * @param ele
     */
    public void delte2(T ele){
        deleteNode2(root,ele);
    }

    /**
     * 删除节点
     * @param node
     * @param ele
     */
    public void deleteNode2(Node<T> node,T ele){
        Node<T> parent = getParent(node,ele);

        //0:根结点 1：左结点 2：右结点
        int flag = parent == null ? 0 : ele.compareTo(parent.left.value) == 0 ? 1 : 2;
//        if(parent == null){
//            //要删除的节点为根节点
//            deleteNode = node;
//        }else if(ele.compareTo(parent.left.value) == 0){
//            deleteNode = node.left;
//        }else if(ele.compareTo(parent.right.value) == 0){
//            deleteNode = node.right;
//        }
        Node<T> deleteNode = flag == 0 ? node : flag == 1 ? node.left : node.right;
        //对要删除的结点进行处理
        Node<T> newNode = null;
        if(deleteNode.left == null && deleteNode.right == null) {
            //叶子结点
        }else if(deleteNode.right == null){
            //1、只有左树
            newNode = deleteNode.left;
            deleteNode.left = null;
            size--;
        }else if(deleteNode.left == null){
            //只有右子树
            newNode = deleteNode.right;
            deleteNode.right = null;
            size--;
        }else{
            //既有左子树又有右子树
            Node<T> minNode = getMin(deleteNode.right);
            Node<T> rightNode = removeMin(deleteNode.right);
            minNode.left = deleteNode.left;
            minNode.right = rightNode;
            deleteNode.left = deleteNode.right = null;
            newNode = minNode;
            size--;
        }

        if(flag == 0){
            root = newNode;
        }else if(flag == 1){
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
    }

    /**
     * 获取某个值的父结点
     * @param ele
     * @return
     */
    public Node<T> getParent(Node<T> node,T ele){
        if(node == null){
            throw new RuntimeException("node 不能为空");
        }

        if(node.left != null && ele.compareTo(node.left.value) == 0){
            return node;
        }
        if(node.right != null && ele.compareTo(node.right.value) == 0){
            return node;
        }
        if(ele.compareTo(node.value) < 0){
            return getParent(node.left,ele);
        }
        if(ele.compareTo(node.value) > 0){
            return getParent(node.right,ele);
        }
        //ele的值等于根结点的值，根结点的双亲结点为null
        return null;
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrderTraversal(Node<T> node){
        if(node == null){
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                Node<T> currNode = stack.pop();
                System.out.print(currNode.value + ",");
                if(currNode.right != null){
                    node = currNode.right;
                }
            }
        }

    }


    public Node<T> removeMin(Node<T> node){
        if(node == null){
            return null;
        }
        if(node.left != null){
            node.left = removeMin(node.left);
            return node;
        }
        //只有两种情况，1是该结点为叶子节点，2是该节点还有右子树
        //如果该结点为叶子节点
        if(node.right == null){
            return null;
        }
        //右子树
        Node<T> rightNode = node.right;
        node.right = null;
        return rightNode;

    }

    /**
     * 获取某结点下的最大值结点
     * @param node
     * @return
     */
    public Node<T> getMax(Node<T> node){
        if(node == null){
            return null;
        }
        if(node.right == null){
            return node;
        }
        return getMax(node.right);
    }

    public Node<T> getMin(Node<T> node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node;
        }
        return getMin(node.left);
    }

}
