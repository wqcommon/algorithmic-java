package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-14 16:35
 *
 * 自己的实现方案，没有考虑性能
 */
public class Alg24_1 {

    public static void main(String[] args) {
        LFUCache cache = new Alg24_1().new LFUCache(3);
        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        cache.get(1);
        cache.set(4, 40);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);

    }


    private class LFUCache {

        private Node head;

        private Node tail;

        private int size;

        private int count;

        private class Node{

            int key;
            int value;
            int count; //访问次数

            Node pre;
            Node next;

            public Node(int key,int value){
                this.key = key;
                this.value = value;
            }
            public Node(int key,int value,int count){
                this.key = key;
                this.value = value;
                this.count = count;
            }


        }

        /*
         * @param capacity: An integer
         */
        public LFUCache(int capacity) {
            // do intialization if necessary
            if(capacity <= 0){
                throw new RuntimeException("illegal exception");
            }
            this.size = capacity;
        }

        /*
         * @param key: An integer
         * @param value: An integer
         * @return: nothing
         */
        public void set(int key, int value) {
            // write your code here
            //查找
            Node curNode = head;
            while (curNode != null && curNode.key != key){
                curNode = curNode.next;
            }
            if(curNode != null){
                //已经存在
                curNode.value = value;
                curNode.count++;
                return;
            }
            //不存在
            Node node = new Node(key,value,1);
            if(count < size){
                //缓存未满
                if(head == null){
                    head = tail = node;
                }else {
                    //在末尾添加
                    tail.next = node;
                    node.pre = tail;
                    tail = node;
                }
                count++;
            }else{
                //缓存已满
                //查找访问次数最少的
                Node minNode = head;
                Node tmpNode = head.next;
                while (tmpNode != null){
                    if(tmpNode.count < minNode.count){
                        minNode = tmpNode;
                    }
                    tmpNode = tmpNode.next;
                }
                //淘汰
                if(minNode.pre == null ){
                    //head
                    head = head.next;
                }
                if(minNode.next == null){
                    //tail
                    tail = tail.pre;
                }
                if(minNode.pre != null && minNode.next != null){
                    minNode.pre.next = minNode.next;
                    minNode.next.pre = minNode.pre;
                    minNode.next = null; //Help GC
                    minNode.pre = null; //Help GC
                }

//                if(minNode.pre == null && minNode.next == null){
//                    head = tail = null;
//                }else if(minNode.pre == null ){
//                    //head
//                    head.next.pre = null;
//                    head = head.next;
//                }else if(minNode.next == null){
//                    //tail
//                    tail.pre.next = null;
//                    tail = tail.pre;
//                }else {
//                    //minNode.pre != null && minNode.next != null
//                    minNode.pre.next = minNode.next;
//                    minNode.next.pre = minNode.pre;
//                    minNode.next = null; //Help GC
//                    minNode.pre = null; //Help GC
//                }
                if(head == null){
                    head = tail = node;
                }else {
                    head.pre = null; // 当minNode.pre == null && minNode.next != null
                    tail.next = null; // 当minNode.pre != null && minNode.next == null
                    tail.next = node;
                    node.pre = tail;
                    tail = node;
                }
            }
        }

        /*
         * @param key: An integer
         * @return: An integer
         */
        public int get(int key) {
            // write your code here
            Node curNode = head;
            while (curNode != null && curNode.key != key){
                curNode = curNode.next;
            }
            if(curNode == null){
                //没有该元素
                return -1;
            }
            //有
            curNode.count++;
            /**
             * 为了处理当访问次数一样，按照访问时间远近来淘汰（淘汰最久未使用的）的情况
             * 需要每次都把该节点放到tail
             */
            if(curNode.next != null){
                //tail节点不需要调整
                if(curNode.pre == null ){
                    //head and head.next != null
                    curNode.next.pre = null;
                    head = curNode.next;
                }else if(curNode.pre != null){
                    curNode.pre.next = curNode.next;
                    curNode.next.pre = curNode.pre;
                }
                tail.next = curNode;
                curNode.pre = tail;
                curNode.next = null;
                tail = curNode;
            }
            return curNode.value;
        }
    }
}
