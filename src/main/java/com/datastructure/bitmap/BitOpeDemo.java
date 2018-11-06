package com.datastructure.bitmap;

/**
 * @author qiang.wen
 * @date 2018/10/25 17:17
 *
 * 位运算
 */
public class BitOpeDemo {

    public static void main(String[] args) {

        System.out.println(add(7,9));

    }


    private static int add(int a, int b){
        if(b == 0){
            return a;
        }
        return add(a ^ b, (a&b) << 1);
    }

    private static int subtract(int a,int b){
        return 0;
    }
}
