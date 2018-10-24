package com.datastructure.graph.adt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qiang.wen
 * @date 2018/10/24 10:49
 *
 *  有向图（邻接表表示）
 *
 */
public class DirectedGraphOfAdjTable {

    private List<Vertex> vertexs;//顶点

    private List<ArcWithWeight> arcs;//弧集合

    public DirectedGraphOfAdjTable(){}

    public DirectedGraphOfAdjTable(List<Vertex> vertexs, List<ArcWithWeight> arcs) {
        this.vertexs = vertexs;
        this.arcs = arcs;
    }

    /**
     * 拓扑排序
     * @return
     */
    public List<Vertex> topologySort(){
        //构造支持拓扑排序的图的ADT
        GraphOfTopolySort graph = new GraphOfTopolySort();
        graph.buildGraph(this.vertexs,this.arcs);
        List<VertexOfInDegree> vertexOfInDegrees = graph.topolygySort();
        List<Vertex> rVertexs = new ArrayList<>(vertexOfInDegrees.size());
        for(VertexOfInDegree v : vertexOfInDegrees){
            rVertexs.add(new Vertex(v.label));
        }
        return rVertexs;
    }

    private static class GraphOfTopolySort{

        private VertexOfInDegree[] vertexArr;

        public void buildGraph(List<Vertex> vertexList,List<ArcWithWeight> arcList){
            //构造顶点
            vertexArr = new VertexOfInDegree[vertexList.size()];
            for(int i = 0; i < vertexList.size(); i++){
                VertexOfInDegree v = new VertexOfInDegree(vertexList.get(i).label);
                vertexArr[i] = v;
            }
            sortVertex(vertexArr);
            //通过弧构造入度和弧链表
            for(ArcWithWeight arc : arcList){
                int tail = binarySearch(vertexArr,arc.tailVertex.label);//弧尾的下标
                if(tail == -1){
                    throw new RuntimeException("构造图失败");
                }
                int head = binarySearch(vertexArr,arc.headVertex.label);//弧头的下标
                if(head == -1){
                    throw new RuntimeException("构造图失败");
                }
                ArcWithNext arcNext = new ArcWithNext(tail,head,arc.weight);
                //添加弧
                VertexOfInDegree tailVertex = vertexArr[tail];
                addArc(tailVertex,arcNext);
                //增加入度
                vertexArr[head].inDegree += 1;
            }

        }

        /**
         * 拓扑排序
         * 算法描述：
         * 从AOV网中选择一个入度为0的顶点输出,然后删除此顶点，并删除以此顶点为尾的弧；
         * 继续重复此步骤，直到输出全部顶点或者AOV网中不存在入度为0的顶点为止。
         *
         *
         * @return
         */
        public List<VertexOfInDegree> topolygySort(){
            List<VertexOfInDegree> rVertexs = new ArrayList<>();//拓扑序列
            Stack<Integer> idxStack = new Stack<>();//入度为0的顶点下标
            for(int i = 0; i < vertexArr.length; i++){
                if(vertexArr[i].inDegree == 0){
                    idxStack.push(i);
                }
            }
            while (!idxStack.isEmpty()){
                //出列
                int idx = idxStack.pop();
                //添加至拓扑序列
                rVertexs.add(vertexArr[idx]);
                ArcWithNext arc = vertexArr[idx].firstArc;
                while (arc != null){
                    if(--vertexArr[arc.head].inDegree == 0){
                        idxStack.push(arc.head);
                    }
                    arc = arc.next;
                }
            }
            if(rVertexs.size() < vertexArr.length){
                throw new RuntimeException("该AOV网存在环");
            }
            return rVertexs;

        }

        /**
         * 添加弧
         * @param tailVertex
         * @param arcNext
         */
        private void addArc(VertexOfInDegree tailVertex, ArcWithNext arcNext) {
            if(tailVertex.firstArc == null){
                tailVertex.firstArc = arcNext;
            }else {
                arcNext.next = tailVertex.firstArc;
                tailVertex.firstArc = arcNext;
            }
        }

        /**
         * 二分查找，在一个有序的线性表中查找
         * @param vertexArr
         * @param label
         * @return
         */
        private int binarySearch(VertexOfInDegree[] vertexArr, int label) {

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
         * 顶点数组排序（升序排列），使用插入排序
         * @param vertexArr
         */
        private void sortVertex(VertexOfInDegree[] vertexArr) {

            for(int i = 1; i < vertexArr.length; i++){
                int j = i-1;
                VertexOfInDegree tmp = vertexArr[i];
                for(;j >= 0 && vertexArr[j].label > tmp.label; j--){
                    vertexArr[j+1] = vertexArr[j];
                }
                vertexArr[j+1] = tmp;
            }
        }

    }

    /**
     * 带有入度的顶点
     */
    private static class VertexOfInDegree extends Vertex{

        int inDegree;//入度

        ArcWithNext firstArc;//第一条弧

        public VertexOfInDegree(int label) {
            super(label);
        }
    }

    private static class ArcWithNext{
        int tail;//弧尾顶点下标
        int head;//弧头顶点下标
        int weight;//权重
        ArcWithNext next;//下一个

        public ArcWithNext(int tail, int head,int weight) {
            this.tail = tail;
            this.head = head;
            this.weight = weight;
        }
    }















    public List<Vertex> getVertexs() {
        return vertexs;
    }

    public void setVertexs(List<Vertex> vertexs) {
        this.vertexs = vertexs;
    }

    public List<ArcWithWeight> getArcs() {
        return arcs;
    }

    public void setArcs(List<ArcWithWeight> arcs) {
        this.arcs = arcs;
    }
}
