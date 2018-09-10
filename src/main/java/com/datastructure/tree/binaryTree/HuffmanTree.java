package com.datastructure.tree.binaryTree;

/**
 * @author qiang.wen
 * @date 2018/9/7 15:55
 *
 * 哈夫曼树的使用
 *
 */
public class HuffmanTree {


    public static void main(String[] args) {
        TreeNode A = new TreeNode("A",27);
        TreeNode B = new TreeNode("B",8);
        TreeNode C = new TreeNode("C",15);
        TreeNode D = new TreeNode("D",15);
        TreeNode E = new TreeNode("E",30);
        TreeNode F = new TreeNode("F",5);

        TreeNode[] nodes = {A,B,C,D,E,F};
        //使用堆排序，得到升序列表
        heapSort(nodes);
        //构造哈夫曼树
        TreeNode root = buildHaffmanTree(nodes);
        //获取哈夫曼编码


        System.out.println(1);
    }

    /**
     * 构造哈夫曼树
     * @param nodes
     * @return
     */
    private static TreeNode buildHaffmanTree(TreeNode[] nodes) {
        int startIdx = 0;
        TreeNode root = null;
        while (startIdx < nodes.length - 1){
            TreeNode left = nodes[startIdx];
            TreeNode right = nodes[startIdx + 1];
            root = new TreeNode(null,left.weight + right.weight);
            root.left = left;
            root.right = right;
            startIdx ++;
            insertTreeNode(nodes,root,startIdx + 1);
        }
        return root;
    }


    private static class TreeNode{

        private String data;

        private int weight;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(String data,int weight){
            this.data = data;
            this.weight = weight;
        }

    }

    /**
     * 把treeNode插入到一个有序的数组中
     * @param nodes
     * @param node
     * @param startIndex 从数组的哪个索引开始
     */
    private static void insertTreeNode(TreeNode[] nodes,TreeNode node,int startIndex){
        if(startIndex < 1 || startIndex > nodes.length -1){
            return;
        }
        int i = startIndex;
        for(; i < nodes.length ; i++){

            if(nodes[i].weight < node.weight){
                nodes[i-1] = nodes[i];
            }else{
                break;
            }
        }
        nodes[i-1] = node;

    }

    /**
     * 使用堆排序进行排序
     *  大顶堆实现
     * @param nodes
     */
    private static void heapSort(TreeNode[] nodes){

        for(int i = nodes.length -1; i >= 0 ; i--){
            for(int j = i/2 -1; j >=0 ; j--){
                int maxIdx = 2*j + 1;
                if(nodes[2*j + 1].weight < nodes[2*j +2].weight){
                    maxIdx = 2*j + 2;
                }
                if(nodes[maxIdx].weight > nodes[j].weight){
                    TreeNode temp = nodes[j];
                    nodes[j] = nodes[maxIdx];
                    nodes[maxIdx] = temp;
                }
            }
            TreeNode temp = nodes[0];
            nodes[0] = nodes[i];
            nodes[i] = temp;
        }
    }

}
