package com.datastructure.graph;

import com.datastructure.graph.adt.ArcWithWeight;
import com.datastructure.graph.adt.DirectedGraphOfAdjTable;
import com.datastructure.graph.adt.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/10/24 10:19
 *
 * 拓扑排序
 *
 * 相关概念
 * AOV网：
 *  在一个表示工程的有向图中，顶点表示活动，弧表示活动之间的优先关系，这样的有向图称为顶点表示活动的网,称为AOV网（Activity On Vertex Network）
 * 拓扑序列：
 *  设G={V,E}是一个具有n个顶点的有向图，V中顶点序列v1,v2,...,vn，满足若从顶点vi到vj有一条路径，则在顶点序列中顶点vi必在顶点vj之前。
 *  这样的顶点序列为一个拓扑序列
 * 拓扑排序：
 *  对一个有向图构造拓扑序列的过程。若网的全部顶点都被输出，则该网是不存在环的AOV网；若输出的顶点数少了，则该AOV网存在环。
 *
 * 拓扑排序算法：
 *  从AOV网中选择一个入度为0的顶点输出,然后删除此顶点，并删除以此顶点为尾的弧，继续重复此步骤，直到输出全部顶点或者AOV网中不存在入度为0的顶点为止。
 *
 *  时间复杂度O(n+e) ,n为顶点数，e为弧数
 *
 *  拓扑排序的应用场景：用于判断一个工程是否能够顺序进行
 *
 *
 */
public class GraphOfTopologySort {

    public static void main(String[] args) {
        topologySortTest();
    }

    private static void topologySortTest() {
        DirectedGraphOfAdjTable graph = buildDirectedGraphOfAdjTable();
        List<Vertex> vertexList = graph.topologySort();
        for(int i = 0; i < vertexList.size(); i++){
            if(i != vertexList.size() - 1){
                System.out.print(vertexList.get(i).getLabel() + "->");
            }else {
                System.out.print(vertexList.get(i).getLabel());
            }
        }
        System.out.println();
    }

    private static DirectedGraphOfAdjTable buildDirectedGraphOfAdjTable() {
        //顶点集合
        List<Vertex> vertexList = new ArrayList<>(14);
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        Vertex v8 = new Vertex(8);
        Vertex v9 = new Vertex(9);
        Vertex v10 = new Vertex(10);
        Vertex v11 = new Vertex(11);
        Vertex v12 = new Vertex(12);
        Vertex v13 = new Vertex(13);
        vertexList.add(v0);
        vertexList.add(v1);
        vertexList.add(v2);
        vertexList.add(v3);
        vertexList.add(v4);
        vertexList.add(v5);
        vertexList.add(v6);
        vertexList.add(v7);
        vertexList.add(v8);
        vertexList.add(v9);
        vertexList.add(v10);
        vertexList.add(v11);
        vertexList.add(v12);
        vertexList.add(v13);
        //弧集合
        List<ArcWithWeight> arcs = new ArrayList<>(20);
        ArcWithWeight a04 = new ArcWithWeight(v0,v4,1);
        ArcWithWeight a05 = new ArcWithWeight(v0,v5,1);
        ArcWithWeight a011 = new ArcWithWeight(v0,v11,1);
        ArcWithWeight a12 = new ArcWithWeight(v1,v2,1);
        ArcWithWeight a14 = new ArcWithWeight(v1,v4,1);
        ArcWithWeight a18 = new ArcWithWeight(v1,v8,1);
        ArcWithWeight a25 = new ArcWithWeight(v2,v5,1);
        ArcWithWeight a26 = new ArcWithWeight(v2,v6,1);
        ArcWithWeight a29 = new ArcWithWeight(v2,v9,1);
        ArcWithWeight a32 = new ArcWithWeight(v3,v2,1);
        ArcWithWeight a313 = new ArcWithWeight(v3,v13,1);
        ArcWithWeight a47 = new ArcWithWeight(v4,v7,1);
        ArcWithWeight a58 = new ArcWithWeight(v5,v8,1);
        ArcWithWeight a512 = new ArcWithWeight(v5,v12,1);
        ArcWithWeight a65 = new ArcWithWeight(v6,v5,1);
        ArcWithWeight a87 = new ArcWithWeight(v8,v7,1);
        ArcWithWeight a910 = new ArcWithWeight(v9,v10,1);
        ArcWithWeight a911 = new ArcWithWeight(v9,v11,1);
        ArcWithWeight a1013 = new ArcWithWeight(v10,v13,1);
        ArcWithWeight a129 = new ArcWithWeight(v12,v9,1);
        arcs.add(a04);
        arcs.add(a05);
        arcs.add(a011);
        arcs.add(a12);
        arcs.add(a14);
        arcs.add(a18);
        arcs.add(a25);
        arcs.add(a26);
        arcs.add(a29);
        arcs.add(a32);
        arcs.add(a313);
        arcs.add(a47);
        arcs.add(a58);
        arcs.add(a512);
        arcs.add(a65);
        arcs.add(a87);
        arcs.add(a910);
        arcs.add(a911);
        arcs.add(a1013);
        arcs.add(a129);
        return new DirectedGraphOfAdjTable(vertexList,arcs);

    }
}
