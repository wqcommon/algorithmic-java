package com.algorithmic.other.lintcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wenqiang
 * @date: 2019-06-29 10:49
 *
 * 7. 二叉树的序列化和反序列化
 */
public class Alg07 {

    public static void main(String[] args) {

        Alg07 alg07 = new Alg07();
        String str = "3,9,20,#,#,15,7";
        TreeNode treeNode = alg07.deserialize(str);
        System.out.println(alg07.serialize(treeNode));
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        // 前序遍历
        if(root == null){
            return "#," ;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        Queue<String> queue = new LinkedList<>();
        for(String str : data.split(",")){
            queue.offer(str);
        }
        TreeNode node = des(queue);
        return node;
    }


    private TreeNode des(Queue<String> queue) {
        if(!queue.isEmpty()){
            String str = queue.poll();
            if("#".equals(str)){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = des(queue);
            node.right = des(queue);
            return node;
        }
        return null;
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
