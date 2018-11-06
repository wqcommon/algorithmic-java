package com.algorithmic.algorithmic.dynamicprogramming;

/**
 * @author qiang.wen
 * @date 2018/10/30 14:38
 *
 *  装配线问题
 *
 *  问题描述：
 *  假设一个汽车底盘加工有两个装配线，如下如所示，每个装配线都有n个配件站，用于给底盘安装不同的零件，配件站用S表示，
 *  如S(2,3)表示第二条装配线的第三个配件站。两条装配线同一个配件站的工作相同，但是时间不同，
 *  用a表示所花费的时间，如a(2,3)表示装配站2的第三个配件站完成工作的时间。
 *  一般情况下，一个汽车底盘的装配过程就是进入一条装配线然后依次通过配件展，一条装配线内从一个配件站到另一个的时间可以忽略。
 *  但是某些时候可能会需要一些加急的订单，对这些订单仍旧需要经过所有的配件站，但不能在一条装配线上一直运行，这样的最短时间就无法保证。
 *  解决方法就是从一条装配线的配件站转移到另一条装配线的配件站，但转移的过程需要时间，记为t。
 *  问题是：计算出如何选择装配站，保证汽车通过工厂的种时间最小
 */
public class AssemblyLineProblem {

    /**
     *
     * f* = min(f1[n] + x1,f2[n] + x2)
     * f1[j] = e1 + a1[1] (j = 1)
     * f1[j] = min{f1[j-1] + a1[j],f2[j-1] + t2[j-1] + a1[j]}
     * f2[j] = e2 + a2[1] (j=1)
     * f2[j] = min{f2[j-1] + a2[j],f1[j-1] + t1[j-1] + a2[j]}
     *
     */

    public static void main(String[] args) {

        AssemblyFacotry assembly = AssemblyFacotry.init();
        calLeastTimeByRecursive(assembly);

    }


    /**
     * 非递归方式计算
     * @param assembly
     */
    private static void calLeastTime(AssemblyFacotry assembly){
        int[] xfArr = new int[assembly.assemblyStationArr.length];// f1[j]：最短时间
        int[] xlArr = new int[assembly.assemblyStationArr.length];//

    }


    /**
     * 通过递归的方式算出最短时间以及输出对应的装配站
     * @param assembly
     */
    private static void calLeastTimeByRecursive(AssemblyFacotry assembly){

        int min1 = recursiveLeast(assembly.assemblyStationArr,assembly.sTimeArr,assembly.eArr,assembly.xArr,assembly.tArr,0,assembly.assemblyStationArr.length - 1);
        int min2 = recursiveLeast(assembly.assemblyStationArr,assembly.sTimeArr,assembly.eArr,assembly.xArr,assembly.tArr,1,assembly.assemblyStationArr.length - 1);
        int min = (min1 + assembly.xArr[0]) < (min2 + assembly.xArr[1])? (min1 + assembly.xArr[0]) : (min2 + assembly.xArr[1]);
        System.out.println("最短时间为：" + min);
    }

    private static int recursiveLeast(int[] assemblyStationArr, int[][] sTimeArr, int[] eArr, int[] xArr, int[][] tArr, int assemNo, int end) {
        if(end == 0){
            return eArr[assemNo] + sTimeArr[assemNo][0];
        }
        int x1 = recursiveLeast(assemblyStationArr,sTimeArr,eArr,xArr,tArr,assemNo,end - 1) + sTimeArr[assemNo][end];
        int x2;
        if(assemNo == 0){
            x2 = recursiveLeast(assemblyStationArr,sTimeArr,eArr,xArr,tArr,1,end - 1) + tArr[1][end-1] + sTimeArr[assemNo][end];
        }else{
            x2 = recursiveLeast(assemblyStationArr,sTimeArr,eArr,xArr,tArr,0,end - 1) + tArr[0][end-1] + sTimeArr[assemNo][end];
        }
        return x1 < x2 ? x1 : x2;
    }


    private static class AssemblyFacotry{

        private int[] assemblyStationArr;//装配站

        private int[][] sTimeArr;//装配站的处理时间

        private int[] eArr;//进入装配线的时间

        private int[] xArr;//离开装配线的时间

        private int[][] tArr;//切换装配线的时间


        public static AssemblyFacotry init(){
            AssemblyFacotry assemblyFacotry = new AssemblyFacotry();
            int[] assemblyStationArr = {1,2,3,4,5,6};
            assemblyFacotry.assemblyStationArr = assemblyStationArr;
            int[][] sTimeArr = {{7,9,3,4,8,4},{8,5,6,4,5,7}};
            assemblyFacotry.sTimeArr = sTimeArr;
            int[] eArr = {2,4};
            assemblyFacotry.eArr = eArr;
            int[] xArr = {3,2};
            assemblyFacotry.xArr = xArr;
            int[][] tArr = {{2,3,1,3,4},{2,1,2,2,1}};
            assemblyFacotry.tArr = tArr;
            return assemblyFacotry;
        }

    }


}
