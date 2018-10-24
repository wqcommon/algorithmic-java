package com.datastructure.graph.adt;

/**
 * @author qiang.wen
 * @date 2018/10/24 10:38
 *
 *  弧，带有指针和权重
 */
public class ArcWithWeight extends Arc{

    protected int weight;//权重

    public ArcWithWeight(){

    }

    public ArcWithWeight(Vertex tailVertex, Vertex headVertex, int weight) {
        super(tailVertex, headVertex);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

}
