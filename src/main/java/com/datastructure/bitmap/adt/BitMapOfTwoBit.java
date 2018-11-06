package com.datastructure.bitmap.adt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiang.wen
 * @date 2018/10/25 14:52
 *
 * 位图
 * 2位表示一个整数，00:出现0次，01:出现1次,10:出现多次
 * 应用场景：
 * 1、判断一个数字是否出现
 * 2、判断一个数字是否重复
 * 一个int可以存储16个数字
 */
public class BitMapOfTwoBit {

    private int[] bitmap;

    private int length;//最大长度，如100，则能存储[0-99]这100个数字

    private static final int[] bitValueArr = {0x00000001,0x00000003,0x00000004,0x0000000b,0x00000010,0x00000030,0x00000040,0x000000b0,
                                              0x00000100,0x00000300,0x00000400,0x00000b00,0x00001000,0x00003000,0x00004000,0x0000b000,
                                              0x00010000,0x00030000,0x00040000,0x000b0000,0x00100000,0x00300000,0x00400000,0x00b00000,
                                              0x01000000,0x03000000,0x04000000,0x0b000000,0x10000000,0x30000000,0x40000000,0xb0000000,};

    public BitMapOfTwoBit(int length){
        this.length = length;
        int bitmapSize = (length >> 4) + ((length & 15) == 0 ? 0 : 1);
        bitmap = new int[bitmapSize];
    }

    /**
     * 设置某个值
     * @param value
     */
    public void setValue(int value){
        if(value < 0 || value > length -1){
            throw new RuntimeException("value is illegal!");
        }
        int bitmapIdx = value >> 4;//bitmap数组下标
        int bitIdx = (value & 15) << 1;//bitmap[bitmapIdx]下的索引
        //这里使用2位代表一个整数
        int flag = bitmap[bitmapIdx] >>> bitIdx;
        if((flag ^ 0) == 0){
            //00
            bitmap[bitmapIdx] = bitmap[bitmapIdx] | bitValueArr[bitIdx];
        }else if((flag ^ 1) == 0){
            //01
            bitmap[bitmapIdx] = bitmap[bitmapIdx] ^ bitValueArr[bitIdx | 1];
        }
    }

    /**
     * 判断某个值是否存在
     * @param value
     * @return
     */
    public boolean isExist(int value){
        if(value < 0 || value > length -1){
            throw new RuntimeException("value is illegal!");
        }
        int bitmapIdx = value >> 4;
        int nbits = (value & 15) << 1;
        int flag = bitmap[bitmapIdx] >>> nbits;
        if((flag ^ 0) > 0){
            return true;
        }
        return false;
    }

    /**
     * 判断某个值是否重复
     * @param value
     * @return
     */
    public boolean isRepeat(int value){
        if(value < 0 || value > length -1){
            throw new RuntimeException("value is illegal!");
        }
        int bitmapIdx = value >> 4;
        int nbits = (value & 15) << 1;
        int flag = bitmap[bitmapIdx] >>> nbits;
        if(flag > 1){
            return true;
        }
        return false;
    }

    /**
     * 遍历不重复数据
     * @return
     */
    public List<Integer> traverNoRepeatData(){

        List<Integer> retData = new ArrayList<>();
        int idx;
        for(int i = 0; i < bitmap.length; i++){
            idx = i * 16;
            int tmpValue = bitmap[i];
            for(int j = 0; j <= 15; j++){
                if((tmpValue >>> (j << 1)) == 1){
                    retData.add(idx + j);
                }
            }
        }
        return retData;
    }
}
