package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-10-02 14:59
 *
 * 88. 最近公共祖先
 */
public class Alg88 {

    /**
     * 算法要点：
     * 1、把一颗大树递归拆分为小树
     * 2、查找出第一个出现的公共节点
     *
     * @param root
     * @param A
     * @param B
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null){
            return null;
        }
        if(A.val == root.val || B.val == root.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,A,B);
        TreeNode right = lowestCommonAncestor(root.right,A,B);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;

    }

    private static class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
}
