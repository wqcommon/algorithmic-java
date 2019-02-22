package com.datastructure.graph.traversing;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.List;

public class GraphOfAjdTable<T> {

    private VerNode<T>[] verArr;

    public static void main(String[] args) {
        Ver<String> vA = new Ver<>("A");
        Ver<String> vB = new Ver<>("B");
        Ver<String> vC = new Ver<>("C");
        Ver<String> vD = new Ver<>("D");
        Ver<String> vE = new Ver<>("E");
        Ver<String> vF = new Ver<>("F");
        Ver<String> vG = new Ver<>("G");

        Ede<String> eAC = new Ede<>(vA,vC);
        Ede<String> eAD = new Ede<>(vA,vD);
        Ede<String> eAF = new Ede<>(vA,vF);
        Ede<String> eCD = new Ede<>(vC,vD);
        Ede<String> eCB = new Ede<>(vC,vB);
        Ede<String> eCF = new Ede<>(vC,vF);
        Ede<String> eBE = new Ede<>(vB,vE);
        Ede<String> eBG = new Ede<>(vB,vG);
        Ede<String> eEF = new Ede<>(vE,vF);
        Ede<String> eFG = new Ede<>(vF,vG);

        List<Ver<String>> verList = new ArrayList<>();
        verList.add(vA);
        verList.add(vB);
        verList.add(vC);
        verList.add(vD);
        verList.add(vE);
        verList.add(vF);
        verList.add(vG);

        List<Ede<String>> edeList = new ArrayList<>();
        edeList.add(eAC);
        edeList.add(eAD);
        edeList.add(eAF);
        edeList.add(eCD);
        edeList.add(eCB);
        edeList.add(eCF);
        edeList.add(eBE);
        edeList.add(eBG);
        edeList.add(eEF);
        edeList.add(eFG);

        GraphOfAjdTable<String> graph = new GraphOfAjdTable<>();
        GraphOfAjdTable<String> g = graph.buildGraph(verList,edeList);
        System.out.println("深度遍历：");
        graph.dfsTraverse(g);
        System.out.println();
        System.out.println("广度遍历：");
        graph.bfsSearch(g);
    }


    private GraphOfAjdTable buildGraph(List<Ver<String>> verList,List<Ede<String>> edeList){
        GraphOfAjdTable g = new GraphOfAjdTable();
        g.verArr = new VerNode[verList.size()];
        for(int i = 0; i < verList.size(); i++){
            VerNode<String> node = new VerNode<>(verList.get(i).getLable());
            g.verArr[i] = node;
        }
        for(Ede ede : edeList){
            int sIdx = findIdx(ede.getVer().getLable(),g.verArr);
            int eIdx = findIdx(ede.getAdjVer().getLable(),g.verArr);
            //不考虑-1的情况
            EdgNode sNode = new EdgNode(sIdx);
            EdgNode eNode = new EdgNode(eIdx);
            addEde(g.verArr,sIdx,eNode);
            addEde(g.verArr,eIdx,sNode);
        }
        return g;
    }

    /**
     * 添加边
     * @param verArr
     * @param idx
     * @param node
     */
    private void addEde(VerNode[] verArr, int idx, EdgNode node) {
        VerNode ver = verArr[idx];
        if(ver.firEdeNode == null){
            ver.firEdeNode = node;
        }else {
            EdgNode n = ver.firEdeNode;
            while (n.next != null){
                n = n.next;
            }
            n.next = node;
        }
    }

    private <T> int findIdx(T lable, VerNode[] verArr) {
        for(int i = 0; i < verArr.length; i++){
            if(lable == verArr[i].getLable()){
                return i;
            }
        }
        return -1;
    }


    private static class VerNode<T> extends Ver<T>{

        EdgNode firEdeNode;

        public VerNode(T lable) {
            super(lable);
        }
    }

    private static class EdgNode{
        int vIdx;
        EdgNode next;
        EdgNode(int vIdx){
            this.vIdx = vIdx;
        }
    }

    /**
     * 深度遍历/搜索
     * @param g
     */
    private void dfsTraverse(GraphOfAjdTable<String> g ){
        VerNode<String>[] verNodes = g.verArr;
        boolean[] visitedArr = new boolean[g.verArr.length];
        dfs(verNodes,visitedArr,0);
    }

    private void dfs(VerNode<String>[] verNodes, boolean[] visitedArr, int i) {
        visitedArr[i] = true;
        System.out.print(verNodes[i].getLable() + "->");
        EdgNode node = verNodes[i].firEdeNode;
        while (node != null){
            if(!visitedArr[node.vIdx]){
                dfs(verNodes,visitedArr,node.vIdx);
            }
            node = node.next;
        }
    }

    /**
     * 广度遍历/搜索
     * @param g
     */
    private void bfsSearch(GraphOfAjdTable<String> g){
        boolean[] visitedArr = new boolean[g.verArr.length];
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(0);
        visitedArr[0] = true;
        while (!queue.isEmpty()){
            try {
                int idx = queue.dequeue();
                System.out.print(g.verArr[idx].getLable() + "->");
                EdgNode node = g.verArr[idx].firEdeNode;
                while (node != null){
                    if(!visitedArr[node.vIdx]){
                        queue.enqueue(node.vIdx);
                        visitedArr[node.vIdx] = true;
                    }
                    node = node.next;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
