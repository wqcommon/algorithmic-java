package com.datastructure.graph.adt;

/**
 * @author qiang.wen
 * @date 2018/10/23 9:59
 *
 *  边
 */
public class Edge {

    protected Vertex vertex; //当前顶点

    protected Vertex adjVertex; //邻接顶点

    public Edge(){}

    public Edge(Vertex vertex, Vertex adjVertex) {
        this.vertex = vertex;
        this.adjVertex = adjVertex;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public Vertex getAdjVertex() {
        return adjVertex;
    }
}
