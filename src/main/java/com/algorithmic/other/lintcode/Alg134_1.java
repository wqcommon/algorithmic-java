package com.algorithmic.other.lintcode;

/**
 * @author: wenqiang
 * @date: 2019-07-20 21:35
 *
 * 134. LRU缓存策略
 * 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据（get）和写入数据（set）。
 *
 * 获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 *
 * 写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
 *
 * 淘汰最久未使用的
 *
 * 自己的实现方案，没有考虑性能
 */
public class Alg134_1 {


    public static void main(String[] args) {
         LRUCache cache = new Alg134_1().new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        cache.get(2);
        cache.set(4, 1);
        cache.get(1);
        cache.get(2);
    }

    public class LRUCache {

        private class Node{

            int key;
            int value;

            Node pre;
            Node next;

            public Node(int key,int value){
                this.key = key;
                this.value = value;
            }
        }
        int size;
        int num;
        Node head;
        Node tail;

        /*
         * @param capacity: An integer
         */public LRUCache(int capacity) {
            // do intialization if necessary
            if(capacity <= 0){
                throw new RuntimeException("illegal size");
            }
            this.size = capacity;
        }

        /*
         * @param key: An integer
         * @return: An integer
         */
        public int get(int key) {
            // write your code here
            Node sNode = head;
            while (sNode != null && sNode.key != key){
                sNode = sNode.next;
            }
            if(sNode == null){
                return -1;
            }
            int val = sNode.value;
            //存在
            if(sNode != head){
                if(sNode == tail){
                    sNode.pre.next = null;
                    tail = sNode.pre;
                }else {
                    sNode.pre.next = sNode.next;
                    sNode.next.pre = sNode.pre;
                }
                sNode.next = head;
                head.pre = sNode;
                head = sNode;
                head.pre = null;
            }

            return val;
        }

        /*
         * @param key: An integer
         * @param value: An integer
         * @return: nothing
         */
        public void set(int key, int value) {
            // write your code here
            //先判断是否为空
            if(num == 0){
                head = tail = new Node(key,value);
                num++;
            }else {
                //根据key查找Node
                Node sNode = head;
                while (sNode != null && sNode.key != key){
                    sNode = sNode.next;
                }
                if(sNode != null){
                    //已经存在了,放到头部
                    sNode.value = value;
                    if(sNode != head){
                        if(sNode == tail){
                            sNode.pre.next = null;
                            tail = sNode.pre;
                        }else {
                            sNode.pre.next = sNode.next;
                            sNode.next.pre = sNode.pre;
                        }
                        sNode.next = head;
                        head.pre = sNode;
                        head = sNode;
                        head.pre = null;
                    }
                }else {
                    //不存在 判断是否需要淘汰
                    if(num >= size){
                        //需要淘汰的话，淘汰最久未使用
                        Node delNode = tail;
                        tail = delNode.pre;
                        delNode.pre = null;
                        if(tail != null){
                            tail.next = null;
                        }
                        num--;
                    }
                    Node node = new Node(key,value);
                    if(num == 0){
                        head = tail = node;
                    }else {
                        node.next = head;
                        head.pre = node;
                        head = node;
                    }
                    num++;
                }
            }
        }
    }
}
