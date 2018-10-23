package com.datastructure.graph;

import com.datastructure.graph.adt.EdgeWithWeight;
import com.datastructure.graph.adt.UndirectedNetworkOfAdjMatrix;
import com.datastructure.graph.adt.UndirectedNetworkOfEdgeArray;
import com.datastructure.graph.adt.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/10/23 14:35
 *
 *  图的最小生成树
 */
public class GrapOfMiniSpanTree {

    private static final int MAXVALUE = 65535;

    public static void main(String[] args) {

         //普里姆算法
//        UndirectedNetworkOfAdjMatrix graph = buildGrap();
//        int[][] edgeArr = graph.getEdgeArr();
//        for(int i = 0; i < edgeArr.length; i++){
//            for (int j = 0; j < edgeArr.length; j++){
//                if(j == edgeArr.length - 1){
//                    System.out.print(edgeArr[i][j]);
//                }else {
//                    System.out.print(edgeArr[i][j] + "--");
//                }
//            }
//            System.out.println();
//        }
//        List<EdgeWithWeight> edges = miniSpanTreeOfPrim(graph);
//        for(EdgeWithWeight e : edges){
//            System.out.println("(" + e.getVertex().getLabel() + "," + e.getAdjVertex().getLabel() + ") => 权值：" + e.getWeight());
//        }
        //克鲁斯卡尔算法
        UndirectedNetworkOfEdgeArray graph = buildGrapOfEdgeArray();
        for(Vertex v : graph.getVertexArr()){
            System.out.print(v.getLabel() + ",");
        }
        System.out.println();
        for(UndirectedNetworkOfEdgeArray.EdgeWithIdx edge : graph.getEdgeArr()){
            System.out.println("(" + edge.beginIdx + "," + edge.endIdx + ") => 权值：" + edge.weight);
        }

    }

    /**
     * 普里姆算法
     * 定义：
     * 假设N={P,{E}}是连通图，TE是N上最小生成树中边的集合，算法从U={u0}(u0属于V)，TE={}开始。重复执行以下操作：
     * 在所有u属于U，v属于V-U的边（u,v）属于E中找出一条权值最小的边(u0,v0)并入集合TE，同时v0并入U，直至U=V为止。
     * 此时TE中必有n-1条边，则T=（V,{TE}）为N的最小生成树
     * 返回构成最小生成树的边
     * 时间复杂度O(n^2)
     * @param g
     * @return
     */
    private static List<EdgeWithWeight> miniSpanTreeOfPrim(UndirectedNetworkOfAdjMatrix g){
        Vertex[] vertexArr = g.getVertexArr();
        int[][] edgeArr = g.getEdgeArr();
        int[] minWeightArr = new int[vertexArr.length];//最小值,当minWeightArr[i]=0时代表该顶点已加入到最小生成树中
        int[] adjVertexArr = new int[vertexArr.length];//邻接顶点的下标
        //初始化
        minWeightArr[0] = 0;
        adjVertexArr[0] = 0;
        for(int i = 1; i < vertexArr.length; i++){
            minWeightArr[i] = edgeArr[0][i];
            adjVertexArr[i] = 0;
        }
        int min;
        int w = -1;
        for(int k = 1; k < vertexArr.length; k++){
            min = MAXVALUE;
            for(int m = 0; m < minWeightArr.length; m++){
                if(minWeightArr[m] != 0 && minWeightArr[m] < min){
                    min = minWeightArr[m];
                    w = m;
                }
            }
            if(w != -1){
                minWeightArr[w] = 0;
            }
            for(int n = 0; n < vertexArr.length; n++){
                if(minWeightArr[n] != 0 && edgeArr[w][n] < minWeightArr[n]){
                    minWeightArr[n] = edgeArr[w][n];
                    adjVertexArr[n] = w;
                }
            }
        }
        List<EdgeWithWeight> edgeList = new ArrayList<>(vertexArr.length -1);
        for(int i = 1; i < adjVertexArr.length; i++){
            EdgeWithWeight edge = new EdgeWithWeight(vertexArr[adjVertexArr[i]],vertexArr[i],edgeArr[adjVertexArr[i]][i]);
            edgeList.add(edge);
        }
        return edgeList;
    }

    /**
     * 克鲁斯卡尔算法
     *
     * 返回构成最小生成树的边
     * @param g
     * @return
     */
    private static List<EdgeWithWeight> minSpanTreeOfKruskal(UndirectedNetworkOfAdjMatrix g){

        return null;
    }

    /**
     * 构造无向网图（邻接矩阵）
     * @return
     */
    private static UndirectedNetworkOfAdjMatrix buildGrap(){
        //顶点
        List<Vertex> vertexList = new ArrayList<>(9);
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        Vertex v8 = new Vertex(8);
        vertexList.add(v0);
        vertexList.add(v1);
        vertexList.add(v2);
        vertexList.add(v3);
        vertexList.add(v4);
        vertexList.add(v5);
        vertexList.add(v6);
        vertexList.add(v7);
        vertexList.add(v8);
        //边
        List<EdgeWithWeight> edgeList = new ArrayList<>(15);
        EdgeWithWeight v01 = new EdgeWithWeight(v0,v1,10);
        EdgeWithWeight v05 = new EdgeWithWeight(v0,v5,11);
        EdgeWithWeight v12 = new EdgeWithWeight(v1,v2,18);
        EdgeWithWeight v18 = new EdgeWithWeight(v1,v8,12);
        EdgeWithWeight v16 = new EdgeWithWeight(v1,v6,16);
        EdgeWithWeight v23 = new EdgeWithWeight(v2,v3,22);
        EdgeWithWeight v28 = new EdgeWithWeight(v2,v8,8);
        EdgeWithWeight v38 = new EdgeWithWeight(v3,v8,21);
        EdgeWithWeight v36 = new EdgeWithWeight(v3,v6,24);
        EdgeWithWeight v37 = new EdgeWithWeight(v3,v7,16);
        EdgeWithWeight v34 = new EdgeWithWeight(v3,v4,20);
        EdgeWithWeight v47 = new EdgeWithWeight(v4,v7,7);
        EdgeWithWeight v45 = new EdgeWithWeight(v4,v5,26);
        EdgeWithWeight v56 = new EdgeWithWeight(v5,v6,17);
        EdgeWithWeight v67 = new EdgeWithWeight(v6,v7,19);
        edgeList.add(v01);
        edgeList.add(v05);
        edgeList.add(v12);
        edgeList.add(v18);
        edgeList.add(v16);
        edgeList.add(v23);
        edgeList.add(v28);
        edgeList.add(v38);
        edgeList.add(v36);
        edgeList.add(v37);
        edgeList.add(v34);
        edgeList.add(v47);
        edgeList.add(v45);
        edgeList.add(v56);
        edgeList.add(v67);
        UndirectedNetworkOfAdjMatrix graph = new UndirectedNetworkOfAdjMatrix();
        graph.buildGraph(vertexList,edgeList);
        return graph;
    }

    /**
     * 构造无向网图(边集数组)
     * @return
     */
    private static UndirectedNetworkOfEdgeArray buildGrapOfEdgeArray(){
        //顶点
        List<Vertex> vertexList = new ArrayList<>(9);
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        Vertex v8 = new Vertex(8);
        vertexList.add(v0);
        vertexList.add(v1);
        vertexList.add(v2);
        vertexList.add(v3);
        vertexList.add(v4);
        vertexList.add(v5);
        vertexList.add(v6);
        vertexList.add(v7);
        vertexList.add(v8);
        //边
        List<EdgeWithWeight> edgeList = new ArrayList<>(15);
        EdgeWithWeight v01 = new EdgeWithWeight(v0,v1,10);
        EdgeWithWeight v05 = new EdgeWithWeight(v0,v5,11);
        EdgeWithWeight v12 = new EdgeWithWeight(v1,v2,18);
        EdgeWithWeight v18 = new EdgeWithWeight(v1,v8,12);
        EdgeWithWeight v16 = new EdgeWithWeight(v1,v6,16);
        EdgeWithWeight v23 = new EdgeWithWeight(v2,v3,22);
        EdgeWithWeight v28 = new EdgeWithWeight(v2,v8,8);
        EdgeWithWeight v38 = new EdgeWithWeight(v3,v8,21);
        EdgeWithWeight v36 = new EdgeWithWeight(v3,v6,24);
        EdgeWithWeight v37 = new EdgeWithWeight(v3,v7,16);
        EdgeWithWeight v34 = new EdgeWithWeight(v3,v4,20);
        EdgeWithWeight v47 = new EdgeWithWeight(v4,v7,7);
        EdgeWithWeight v45 = new EdgeWithWeight(v4,v5,26);
        EdgeWithWeight v56 = new EdgeWithWeight(v5,v6,17);
        EdgeWithWeight v67 = new EdgeWithWeight(v6,v7,19);
        edgeList.add(v01);
        edgeList.add(v05);
        edgeList.add(v12);
        edgeList.add(v18);
        edgeList.add(v16);
        edgeList.add(v23);
        edgeList.add(v28);
        edgeList.add(v38);
        edgeList.add(v36);
        edgeList.add(v37);
        edgeList.add(v34);
        edgeList.add(v47);
        edgeList.add(v45);
        edgeList.add(v56);
        edgeList.add(v67);
        UndirectedNetworkOfEdgeArray graph = new UndirectedNetworkOfEdgeArray();
        graph.buildGraph(vertexList,edgeList);
        return graph;
    }
}
