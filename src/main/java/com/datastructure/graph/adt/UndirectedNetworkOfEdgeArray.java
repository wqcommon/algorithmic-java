package com.datastructure.graph.adt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiang.wen
 * @date 2018/10/23 16:27
 *
 * 边集数组表示无向网图
 */
public class UndirectedNetworkOfEdgeArray {

    private Vertex[] vertexArr;

    private EdgeWithIdx[] edgeArr;

    /**
     * 边
     */
    public static class EdgeWithIdx{
        public int beginIdx;

        public int endIdx;

        public int weight;

        public EdgeWithIdx(int beginIdx, int endIdx, int weight) {
            this.beginIdx = beginIdx;
            this.endIdx = endIdx;
            this.weight = weight;
        }
    }

    /**
     * 构造图
     * @param vertexList
     * @param edgeWithWeightList
     */
    public void buildGraph(List<Vertex> vertexList,List<EdgeWithWeight> edgeWithWeightList){
        //插入排序，构造顶点数组有序（升序）
        vertexArr = new Vertex[vertexList.size()];
        buildSortVertex(vertexList,vertexArr);
        //插入排序，构造边集数组有序（按照权重排序）
        edgeArr = new EdgeWithIdx[edgeWithWeightList.size()];
        buildSortEdge(edgeWithWeightList,edgeArr);
    }

    /**
     * 插入排序构造有序的边集数组（权重升序排列）
     * @param edgeWithWeightList
     * @param edgeArr
     */
    private void buildSortEdge(List<EdgeWithWeight> edgeWithWeightList, EdgeWithIdx[] edgeArr) {
        Map<Integer,Integer> idxMap = new HashMap<>();//索引Map
        for(int i = 0; i < edgeWithWeightList.size(); i++){
            EdgeWithWeight edge = edgeWithWeightList.get(i);
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
            edgeArr[i] = new EdgeWithIdx(s,e,edge.weight);
        }
        quickSortEdge(edgeArr,0,edgeArr.length-1);
    }

    /**
     * 使用快速排序
     * @param edgeArr
     */
    private void quickSortEdge(EdgeWithIdx[] edgeArr,int start,int end){
        if(start < end){
            //获取枢纽值
            //取start,(start+end)/2,end的中位数，并交换中位数与start的值
            if(edgeArr[(start + end)/2].weight > edgeArr[end].weight){
                swapEdge(edgeArr,(start + end)/2,end);
            }
            if(edgeArr[start].weight < edgeArr[(start + end)/2].weight){
                swapEdge(edgeArr,start,(start + end)/2);
            }else if(edgeArr[start].weight > edgeArr[end].weight){
                swapEdge(edgeArr,start,end);
            }
            int pos = partion(edgeArr,start,end);
            quickSortEdge(edgeArr,start,pos - 1);
            quickSortEdge(edgeArr,pos + 1,end);

        }
    }

    private int partion(EdgeWithIdx[] edgeArr, int start, int end) {
        EdgeWithIdx pivot = edgeArr[start];
        while (start < end){
            while (start < end && edgeArr[end].weight >= pivot.weight){
                end--;
            }
            edgeArr[start] = edgeArr[end];
            while (start < end && edgeArr[start].weight <= pivot.weight){
                start++;
            }
            edgeArr[end] = edgeArr[start];
        }
        edgeArr[start] = pivot;
        return start;
    }

    /**
     * 交换
     * @param edgeArr
     * @param i
     * @param j
     */
    private void swapEdge(EdgeWithIdx[] edgeArr, int i, int j) {
        EdgeWithIdx tmp = edgeArr[i];
        edgeArr[i] = edgeArr[j];
        edgeArr[j] = tmp;
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

    public EdgeWithIdx[] getEdgeArr() {
        return edgeArr;
    }
}
