package com.datastructure.graph.adt;

/**
 * @author qiang.wen
 * @date 2018/10/23 10:41
 *
 * 带权的边
 */
public class EdgeWithWeight extends Edge{

    protected int weight;//权重

    public EdgeWithWeight(){}

    public EdgeWithWeight(Vertex vertex, Vertex adjVertex, int weight) {
        super(vertex, adjVertex);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
