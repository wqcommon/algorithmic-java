package com.datastructure.bitmap;

import com.datastructure.bitmap.adt.BitMapOfOneBit;
import com.datastructure.bitmap.adt.BitMapOfTwoBit;

import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/10/25 14:23
 *
 * 使用位图来处理大数据
 */
public class BitmapOfBigData {


    public static void main(String[] args) {

            testBitMapOfTwoBit();

    }

    /**
     * 测试用2位表示一个数的位图
     */
    private static void testBitMapOfTwoBit(){

        BitMapOfTwoBit bitmap = buildBitMapOfTwoBit();
        testCheckIsExistOfTwoBit(2,bitmap);
        testCheckIsExistOfTwoBit(30,bitmap);
        testCheckIsRepeatOfTwoBit(2,bitmap);
        testCheckIsRepeatOfTwoBit(40000000,bitmap);
        List<Integer> noRepeatDatas = bitmap.traverNoRepeatData();
        for(int i = 0; i < noRepeatDatas.size(); i++){
            if(i == noRepeatDatas.size() - 1){
                System.out.print(noRepeatDatas.get(i));
            }else {
                System.out.print(noRepeatDatas.get(i) + ",");
            }
        }
        System.out.println();
    }

    private static BitMapOfTwoBit buildBitMapOfTwoBit() {
        BitMapOfTwoBit bitmap = new BitMapOfTwoBit(100000000);
        int[] valueArr = {2,2,2,100,100,501,40000000,5000001,3456,3456};
        for(int val : valueArr){
            bitmap.setValue(val);
        }
        return bitmap;
    }

    /**
     * 测试是否存在
     * @param data
     * @param bitMap
     */
    private static void testCheckIsExistOfTwoBit(int data,BitMapOfTwoBit bitMap){
        System.out.println(data + "是否存在：" + bitMap.isExist(data));
    }

    /**
     * 测试是否重复
     * @param data
     * @param bitMap
     */
    private static void testCheckIsRepeatOfTwoBit(int data,BitMapOfTwoBit bitMap){
        System.out.println(data + "是否重复：" + bitMap.isRepeat(data));
    }


    /**
     * 测试用一位表示一个数的位图
     */
    private static void testBitMapOfoneBit(){
        BitMapOfOneBit bitmap = buildBitmap();
        checkIsExist(1000,bitmap);
        checkIsExist(5000,bitmap);
    }

    private static BitMapOfOneBit buildBitmap() {
        long length = Integer.valueOf("100000000");
        BitMapOfOneBit bitmap = new BitMapOfOneBit(length);
        bitmap.setBit(1000);
        bitmap.setBit(99555521);
        bitmap.setBit(26548451);
        bitmap.setBit(2451658);
        bitmap.setBit(5000000);
        return bitmap;
    }


    /**
     * 判断某个大数据是否存在
     * @param data
     * @param bitmap
     */
    private static void checkIsExist(long data, BitMapOfOneBit bitmap){
        System.out.println(data + "是否存在：" + bitmap.isExist(data));
    }
}
