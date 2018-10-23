package com.datastructure.graph.adt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiang.wen
 * @date 2018/10/23 9:54
 *
 *  邻接矩阵来表示无向网（网：带权的图）
 */
public class UndirectedNetworkOfAdjMatrix {

    private Vertex[] vertexArr;//顶点集合

    private int[][] edgeArr;//边的集合，数组的值代表权值,规则：int[i][i]=0,int[i][j]:当i和j为邻接顶点时，为该边的权值，否则为一个设置的最大值

    private final static int MAXWEIGHT = 65535;


    /**
     * 构造图
     * @param vertexList
     * @param edgeList
     * @return
     */
    public void buildGraph(List<Vertex> vertexList,List<EdgeWithWeight> edgeList){

        //使用插入排序构造顶点数组（升序排列）
        vertexArr = new Vertex[vertexList.size()];
        buildSortVertex(vertexList,vertexArr);
        //构造边
        edgeArr = new int[vertexArr.length][vertexArr.length];
        for(int i = 0 ; i < edgeArr.length; i++){
            for(int j = 0; j < edgeArr.length; j++){
                if(i != j){
                    edgeArr[i][j] = MAXWEIGHT;
                }
            }
        }
        Map<Integer,Integer> idxMap = new HashMap<>();//索引Map
        for(EdgeWithWeight edge : edgeList){
            Integer s = idxMap.get(edge.vertex.label);
            Integer e = idxMap.get(edge.adjVertex.label);
            if(s == null){
                //二分查找
                s = binarySearch(vertexArr,edge.vertex.label);
                if (s == -1){
                    throw new RuntimeException("没有找到对应的顶点，构造图失败");
                }
                idxMap.put(edge.vertex.label,s);
            }
            if(e == null){
                e = binarySearch(vertexArr,edge.adjVertex.label);
                if(e == -1){
                    throw new RuntimeException("没有找到对应的顶点，构造图失败");
                }
                idxMap.put(edge.adjVertex.label,e);
            }
            edgeArr[s][e] = edge.weight;
            edgeArr[e][s] = edge.weight;
        }

    }

    /**
     * 二分查找，在一个有序的线性表中查找
     * @param vertexArr
     * @param label
     * @return
     */
    private int binarySearch(Vertex[] vertexArr, int label) {

        //使用非递归方式实现
        int start = 0, end = vertexArr.length -1;
        int mid;
        while (start != end){
            mid = (end + start)/2;
            if(vertexArr[mid].label == label){
                return mid;
            }else if(vertexArr[mid].label > label){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        if(vertexArr[start].label == label){
            return start;
        }else {
            return -1;
        }
    }

    /**
     * 插入排序构造有序的顶点数组（升序排列）
     * @param vertexList
     * @param vertexArr
     */
    private void buildSortVertex(List<Vertex> vertexList, Vertex[] vertexArr) {
        int i = 0;
        while (i < vertexList.size()){
            Vertex v = vertexList.get(i);
            int j = i - 1;
            for(; j >= 0 && vertexArr[j].label > v.label; j--){
                vertexArr[j+1] = vertexArr[j];
            }
            vertexArr[j+1] = v;
            i++;
        }
    }

    public Vertex[] getVertexArr() {
        return vertexArr;
    }

    public int[][] getEdgeArr() {
        return edgeArr;
    }
}
