package com.datastructure.graph.adt;

/**
 * @author qiang.wen
 * @date 2018/10/23 9:57
 *
 * 顶点
 */
public class Vertex {

    protected int label;//标识

    public Vertex(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }
}
