package com.algorithmic.lxt;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-11-01 13:44
 */
public class MaxNumber {

    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();
//        int[] nums = {3,30,34,5,9};
        int[] nums = {1,3,30,305,346,5,58,8};

//        System.out.println(maxNumber.maxNumber(nums));
        System.out.println(maxNumber.maxNumerII(nums));

    }

    /**
     *
     *
     * 给定一个整数数组，将这些数字拼接重组成为最大的正整数
     *
     * [3,30,34,5,9] => 9534330
     *
     * 这种方法太笨
     *
     */
    private String maxNumber(int[] nums){

        // [34,97,9,689,902] => 344 977 999 689 902
        // 99790268934
        int maxBit = 0;
        String[] strNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            String n = String.valueOf(nums[i]);
            if(maxBit < n.length()){
                maxBit = n.length();
            }
            strNums[i] = n;
        }

        for(int i = 0; i < strNums.length; i++){
            String str = strNums[i];
            if(str.length() < maxBit){
                String lastStr = str.substring(str.length() - 1);
                StringBuffer sb = new StringBuffer(str);
                int ns = maxBit - str.length();
                while (ns-- > 0){
                    sb.append(lastStr);
                }
                strNums[i] = sb.toString();
            }
        }

        int[] tmNums = new int[strNums.length];
        for(int i = 0; i < tmNums.length; i++){
            tmNums[i] = Integer.parseInt(strNums[i]);
        }

        int preMax = Integer.MAX_VALUE;
        List<Integer> idxList = new ArrayList<>();
        while (idxList.size() < tmNums.length){
            int max = 0;
            int indx = 0;
            for(int i = 0; i < tmNums.length; i++){
                if(tmNums[i] <= preMax && tmNums[i] > max && !idxList.contains(i)){
                    max = tmNums[i];
                    indx = i;
                }
            }
           idxList.add(indx);
        }
        StringBuffer retSb = new StringBuffer();
        for(Integer idx : idxList){
            retSb.append(String.valueOf(nums[idx]));
        }
        return retSb.toString();
    }


    /**
     *
     * 把思路转换为数组排序问题，定义排序规则
     *
     *
     *  给你任意两个整数，设计一个比较规则，让其组成的整数最大。
     *  其实也是很简单，比如a和b两个整数，把他们两个分别前后拼接成两个整数，再比较一下大小之后就知道谁大谁小
     *
     */
    public String maxNumerII(int[] nums){

        Integer[] numII = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            numII[i] = nums[i];
        }

        Arrays.sort(numII,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int before = Integer.parseInt(String.valueOf(o1) + String.valueOf(o2));
                int after = Integer.parseInt( String.valueOf(o2) + String.valueOf(o1));
                return after - before;
            }
        });

        StringBuffer stringBuffer = new StringBuffer();
        for(int num : numII){
            stringBuffer.append(String.valueOf(num));
        }
        return stringBuffer.toString();
    }
}
