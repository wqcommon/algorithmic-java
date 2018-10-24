package com.datastructure.graph.adt;

/**
 * @author qiang.wen
 * @date 2018/10/23 10:00
 *
 *  弧
 */
public class Arc {

    protected Vertex tailVertex;//弧尾

    protected Vertex headVertex;//弧头

    public Arc(){}

    public Arc(Vertex tailVertex, Vertex headVertex) {
        this.tailVertex = tailVertex;
        this.headVertex = headVertex;
    }

    public Vertex getTailVertex() {
        return tailVertex;
    }

    public Vertex getHeadVertex() {
        return headVertex;
    }
}
