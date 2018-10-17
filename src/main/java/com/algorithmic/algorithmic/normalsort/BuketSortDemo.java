package com.algorithmic.algorithmic.normalsort;

import java.util.Arrays;

/**
 * @author qiang.wen
 * @date 2018/10/16 14:19
 *
 * 桶排序
 * 桶排序的思路：
 * 1、将输入的数据均匀的分配到有限数量的桶中（桶与桶之间是有序的）
 * 2、对每个桶的数据分别进行排序（可以采用任何一种排序方式），桶中的数据可以采用链表或者数组存储
 * 3、最后将每个桶中的数据有序的组合起来
 *
 * 分而治之的思想
 *
 * 时间复杂度近似O(n)
 * 应用场景：
 *
 */
public class BuketSortDemo {

    public static void main(String[] args) {
        int[] arr = {7,26,23,11,15,11,9,5,47,43,46,78,75,98,30,36,65,62,61};
        buketSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 桶排序
     * 例如： 对20个范围在[0-99]的数字进行排序，提供10个桶
     * 这里对于桶中的数据采用单链表的方式进行存储
     * @param arr
     */
    public static void  buketSort(int[] arr){

        Node[] bulketArr = new Node[10];
        for(int i = 0; i < arr.length; i++){
            int buketIdx = arr[i]/10;
            Node node = new Node(arr[i]);
            if(bulketArr[buketIdx] == null){
                bulketArr[buketIdx] = node;
            }else {
                //有序的插入到对应的位置
                Node head = bulketArr[buketIdx];
                if(arr[i] < head.val){
                    //把arr[i]变为头元素
                    bulketArr[buketIdx] = node;
                    node.next = head;
                }else{
                    //查找到合适的位置
                    while (head.next != null && head.next.val <= arr[i]){
                        head = head.next;
                    }
                    if(head.next == null){
                        head.next = node;
                    }else{
                        node.next = head.next;
                        head.next = node;
                    }
                }

            }
        }
        int idx = 0;
        for(int j = 0; j < bulketArr.length; j++){
            Node head = bulketArr[j];
            if(head != null){
               arr[idx++] = head.val;
               while (head.next != null){
                   head = head.next;
                   arr[idx++] = head.val;
               }
            }
        }


    }

    /**
     * 桶排序
     * 采用二维数组来实现
     *
     * 优势：
     * 1、简单，可以使用插入排序进行排序
     *
     * 劣势：
     * 1、相对链表来说，会造成一定的空间浪费
     * @param arr
     */
    public static void buketSort2(int[] arr){
        int[][] buketArr = new int[10][arr.length];//二维数组存储
        int[] buketIdxArr = new int[10];//每个桶当前存储的位置
        for(int i = 0; i < arr.length; i++){
            int ele = arr[i];
            int buketIdx = ele/10;
            if(buketIdxArr[buketIdx] == 0){
                //表示当前桶还未有元素
                buketArr[buketIdx][0] = ele;
                buketIdxArr[buketIdx]++;
            }else {
                //插入排序
                int k = buketIdxArr[buketIdx] - 1;
                for(; k >= 0 && buketArr[buketIdx][k] > ele; k--){
                    buketArr[buketIdx][k + 1] = buketArr[buketIdx][k];
                }
                buketArr[buketIdx][k+1] = ele;
                buketIdxArr[buketIdx]++;
            }
        }
        int idx = 0;
        for(int m = 0; m < buketArr.length; m++){
            for(int l = 0; l < buketIdxArr[m]; l++){
                arr[idx++] = buketArr[m][l];
            }
        }

    }





    private static class Node{

        int val;

        Node next;

        public Node(int val){
            this.val = val;
        }
    }
}
