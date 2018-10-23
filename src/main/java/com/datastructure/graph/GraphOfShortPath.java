package com.datastructure.graph;

import java.util.Stack;

/**
 * @author qiang.wen
 * @date 2018/10/19 10:21
 *
 * 图中的最短路径
 * 使用邻接矩阵来表示图
 *
 * 两种算法：
 * 1、迪杰斯特拉算法
 * 2、弗洛伊德算法
 */
public class GraphOfShortPath {

    private int[] vertexArr;

    private int[][] edgeArr;

    private static final int MAXVALUE = 65535;

    public GraphOfShortPath(int[] vertexArr, int[][] edgeArr){
        this.vertexArr = vertexArr;
        this.edgeArr = edgeArr;
    }

    public int[] getVertexArr() {
        return vertexArr;
    }

    public void setVertexArr(int[] vertexArr) {
        this.vertexArr = vertexArr;
    }

    public int[][] getEdgeArr() {
        return edgeArr;
    }

    public void setEdgeArr(int[][] edgeArr) {
        this.edgeArr = edgeArr;
    }


    public static void main(String[] args) {
        GraphOfShortPath g = buildGraph();
        for(int i = 0; i < g.edgeArr.length; i++){
            for(int j = 0; j < g.edgeArr.length; j++){
                if(j == g.edgeArr.length - 1){
                    System.out.print(g.edgeArr[i][j]);
                }else {
                    System.out.print(g.edgeArr[i][j] + ",");
                }
            }
            System.out.println();
        }
        dijkstraAlgorith(g,8,6);
    }


    /**
     * 构造用邻接矩阵构造的网（边带权值的图）
     * @return
     */
    private static GraphOfShortPath buildGraph(){
        int[] vertextArr = {0,1,2,3,4,5,6,7,8};
        int[][] edgeArr = new int[vertextArr.length][vertextArr.length];
        //初始化边
        for(int i = 0; i < edgeArr.length; i++){
            for(int j = 0; j < edgeArr.length; j++){
                if(i == j){
                    edgeArr[i][j] = 0;
                }else{
                    if(i == 0 && j == 1){
                        edgeArr[i][j] = 1;
                        edgeArr[j][i] = 1;
                    }else if(i == 0 && j == 2){
                        edgeArr[i][j] = 5;
                        edgeArr[j][i] = 5;
                    }else if(i == 1 && j == 2){
                        edgeArr[i][j] = 3;
                        edgeArr[j][i] = 3;
                    }else if(i == 1 && j == 4){
                        edgeArr[i][j] = 5;
                        edgeArr[j][i] = 5;
                    }else if(i == 1 && j == 3){
                        edgeArr[i][j] = 7;
                        edgeArr[j][i] = 7;
                    }else if(i == 2 && j == 4){
                        edgeArr[i][j] = 1;
                        edgeArr[j][i] = 1;
                    }else if(i == 2 && j == 5){
                        edgeArr[i][j] = 7;
                        edgeArr[j][i] = 7;
                    }else if(i == 3 && j == 4){
                        edgeArr[i][j] = 2;
                        edgeArr[j][i] = 2;
                    }else if(i == 3 && j == 6){
                        edgeArr[i][j] = 3;
                        edgeArr[j][i] = 3;
                    }else if(i == 4 && j == 5){
                        edgeArr[i][j] = 3;
                        edgeArr[j][i] = 3;
                    }else if(i == 4 && j == 6){
                        edgeArr[i][j] = 6;
                        edgeArr[j][i] = 6;
                    }else if(i == 4 && j == 7){
                        edgeArr[i][j] = 9;
                        edgeArr[j][i] = 9;
                    }else if(i == 5 && j == 7){
                        edgeArr[i][j] = 5;
                        edgeArr[j][i] = 5;
                    }else if(i == 6 && j == 7){
                        edgeArr[i][j] = 2;
                        edgeArr[j][i] = 2;
                    }else if(i == 6 && j == 8){
                        edgeArr[i][j] = 7;
                        edgeArr[j][i] = 7;
                    }else if(i == 7 && j == 8){
                        edgeArr[i][j] = 4;
                        edgeArr[j][i] = 4;
                    }else if(edgeArr[i][j] == 0){
                        edgeArr[i][j] = MAXVALUE;
                    }

                }
            }
        }

        return new GraphOfShortPath(vertextArr,edgeArr);
    }

    /**
     * 求两个顶点间的最短距离
     * 迪杰斯特拉算法
     */
    private static void dijkstraAlgorith(GraphOfShortPath g, int startVertex, int endVertex){
        int[] shortWeightArr = new int[g.vertexArr.length];//startVertex到各顶点的最短路径权值之和数组
        int[] pathMatrixArr = new int[g.vertexArr.length];//startVertex到各点最短路径前驱顶点下标数组
        int[] isSortPathArr = new int[g.vertexArr.length];//isSortPathArr[k]=1表示已算出startVertex到k的最短路径

        //初始化数据
        for(int i = 0; i < g.vertexArr.length; i++){
            shortWeightArr[i] = g.edgeArr[startVertex][i];
            pathMatrixArr[i] = startVertex;
        }
        isSortPathArr[startVertex] = 1;

        for(int i = 1; i < g.vertexArr.length; i++){

            //获取最小值
            int min = MAXVALUE;
            int s = -1;
            for(int j = 0; j < shortWeightArr.length; j++){
                if(isSortPathArr[j] != 1 && shortWeightArr[j] < min){
                    min = shortWeightArr[j];
                    s = j;
                }
            }
            if(s != -1){
                isSortPathArr[s] = 1;
            }
            //调整最短路径权值
            for(int j = 0; j < g.vertexArr.length; j++){
                if(isSortPathArr[j] != 1 && min + g.edgeArr[s][j] < shortWeightArr[j]){
                    shortWeightArr[j] = min + g.edgeArr[s][j];
                    pathMatrixArr[j] = s;
                }
            }
        }
        //最短路径经过的顶点
        Stack stack = new Stack();
        int endIdx = endVertex;
        stack.push(endVertex);
        while (pathMatrixArr[endIdx] != startVertex){
            endIdx = pathMatrixArr[endIdx];
            stack.push(endIdx);
        }
        stack.push(startVertex);
        System.out.println(startVertex + " 到 " + endVertex + " 的最短路径经过的顶点为：");
        while (!stack.isEmpty()){
            if(stack.size() == 1){
                System.out.print(stack.pop());
            }else{
                System.out.print(stack.pop() + "-->");
            }
        }
        System.out.println();
        System.out.println("最短路径长度为：" + shortWeightArr[endVertex]);

    }

    /**
     * 求所有顶点到所有顶点的最短路径
     * 弗洛伊德算法
     * @param g
     */
    private static void floydAlgorith(GraphOfShortPath g){
            //TODO 不是很理解
        /**
         *
         * D[v][w] = min{D[v][w],D[v][k]+D[k][w]}
         * P[v][w] = P[v][k]
         *
         */

    }
}
