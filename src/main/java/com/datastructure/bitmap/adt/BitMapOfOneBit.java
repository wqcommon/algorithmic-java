package com.datastructure.bitmap.adt;

/**
 * @author qiang.wen
 * @date 2018/10/25 11:00
 *
 * 位图（每一个bit表示一个数字）
 *
 * 思路：
 * 一个int类型包含4个byte（32位），能代表32个数 => 使用int数组来表示位图
 *
 * 存储数据的步骤：
 *
 * 例如：
 * int[] bitmap => bitmap[0]:0-31,bitmap[1]:32-63
 * int i = 60
 * 1、60 << 5 = 1 表示60落在bitmap[1]上，类似算术运算符中的 60/32 = 1;
 * 2、60 & 31 = 28 表示 60落在bitmap[1]的下标为28的位上
 * 3、将bitmap[1]的值按位或2^28 => 将下标为28的位的值设置为1
 */
public class BitMapOfOneBit {

    private int[] bitmap;//位图

    private long length;//数字长度，例如100代表允许插入bitmap的最大数为99即[0-99]

    //2^0,2^1,...,2^31
    private int[] bitValueArr = {0x00000001,0x00000002,0x00000004,0x00000008,0x00000010,0x00000020,0x00000040,0x00000080,
                                 0x00000100,0x00000200,0x00000400,0x00000800,0x00001000,0x00002000,0x00004000,0x00008000,
                                 0x00010000,0x00020000,0x00040000,0x00080000,0x00100000,0x00200000,0x00400000,0x00800000,
                                 0x01000000,0x02000000,0x04000000,0x08000000,0x10000000,0x20000000,0x40000000,0x80000000};

    public BitMapOfOneBit(long length){
        this.length = length;
        //位图数组的大小
        int bitmapSize = (int)(length >> 5) + ((length & 31) == 0 ? 0 : 1) ;
        bitmap = new int[bitmapSize];
    }

    /**
     * 插入值
     * @param value
     */
    public void setBit(long value){
        if(value < 0 || value > length - 1){
            throw new RuntimeException("value is illegal!");
        }
        //获取bitmap的下标
        int bitmapIdx = (int)value >> 5;
        //获取bitValeArr的下标，代表value存放在bitmap[bitmapIdx]的存放位置
        int bitValueIdx = (int)value & 31;
        //把bitValueIdx对应的位值设置为1
        bitmap[bitmapIdx] = bitmap[bitmapIdx] | bitValueArr[bitValueIdx];

    }

    /**
     * 判断某个值是否存在
     * @param value
     * @return
     */
    public boolean isExist(long value){
        if(value < 0 || value > length - 1){
            throw new RuntimeException("value is illegal!");
        }
        int bitmapIdx = (int)value >> 5;
        int bitValueIdx = (int)value & 31;
        // 无符号右移：>>>，在前面补0
        int flag = (bitmap[bitmapIdx] & bitValueArr[bitValueIdx]) >>> bitValueIdx;
        if(flag > 0){
            return true;
        }
        return false;
    }

}
