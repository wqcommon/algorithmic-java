package com.datastructure.graph.traversing;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接矩阵表示图
 */
public class GraphOfAdjMatrix<T> {

    private Ver<T>[] verArrs;

    private List<Ede<T>> edes;

    private int[][] edeArr;

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

        GraphOfAdjMatrix graph = new GraphOfAdjMatrix();
        GraphOfAdjMatrix g = graph.buildGraph(verList,edeList);
        System.out.println("深度遍历：");
        graph.dfsTraverse(g);
        System.out.println();
        System.out.println("广度遍历：");
        graph.bfsSearch(g);
    }

    private GraphOfAdjMatrix<T> buildGraph(List<Ver<T>> verList, List<Ede<T>> edeList){
        GraphOfAdjMatrix g = new GraphOfAdjMatrix();
        g.verArrs = new Ver[verList.size()];
        g.edes = edeList;
        g.edeArr = new int[verList.size()][verList.size()];
        for(int i = 0; i < g.verArrs.length; i++){
            g.verArrs[i] = verList.get(i);
        }
        for(int i = 0; i < g.edes.size(); i++){
            Ede ede = edeList.get(i);
            int idx1 = findIdx(ede.getVer(),g.verArrs);
            int idx2 = findIdx(ede.getAdjVer(),g.verArrs);
            //不处理-1的情况
            g.edeArr[idx1][idx2] = 1;
            g.edeArr[idx2][idx1] = 1;
        }
        return g;

    }

    private int findIdx(Ver ver, Ver[] verArrs) {
        for(int i = 0; i < verArrs.length; i++){
            if(ver.getLable() == verArrs[i].getLable()){
                return i;
            }
        }
        return -1;

    }

    /**
     * 深度遍历
     * @param graph
     */
    private void dfsTraverse(GraphOfAdjMatrix graph){
        Ver<T>[] verArr = graph.verArrs;
        int[][] edeArr = graph.edeArr;
        boolean[] visitedArr = new boolean[verArr.length];
        dfs(verArr,edeArr,visitedArr,0);

    }

    /**
     * 深度遍历
     * @param verArr
     * @param edeArr
     * @param visitedArr
     * @param i
     */
    private void dfs(Ver<T>[] verArr, int[][] edeArr, boolean[] visitedArr, int i) {
        visitedArr[i] = true;
        System.out.print(verArr[i].getLable() + "->");
        for(int k = 0; k < verArr.length; k++){
            if(!visitedArr[k] && edeArr[i][k] == 1){
                dfs(verArr,edeArr,visitedArr,k);
            }
        }
    }

    /**
     * 广度优先遍历/搜索
     * @param graph
     */
    private void bfsSearch(GraphOfAdjMatrix graph){
        boolean[] visitedArr = new boolean[graph.verArrs.length];
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(0);
        visitedArr[0] = true;
        while (!queue.isEmpty()){
            try {
                int idx = queue.dequeue();
                System.out.print(graph.verArrs[idx].getLable() + "->");
                for(int i = 0; i < graph.verArrs.length; i++){
                    if(graph.edeArr[idx][i] == 1 && !visitedArr[i]){
                        queue.enqueue(i);
                        visitedArr[i] = true;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
