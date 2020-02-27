package com.algorithmic.leetcode;

/**
 * @author: wenqiang
 * @date: 2019-12-13 19:08
 */
public class A_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int pre = 0; //前一个值
        int curr = 0; //当前值
        int n1 = 0, n2 = 0;
        for(int i = 0; i < len/2 + 1; i++){
            //遍历的次数
            pre = curr;
            if(n1 < m && (n2 >= n || nums1[n1] <= nums2[n2])){
                curr = nums1[n1++];
            }else {
                curr = nums2[n2++];
            }
        }
        if(len % 2 == 0){
            return (pre + curr) / 2.0;
        }else {
            return curr;
        }

    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int curIdx = -1;
        int targetIdx = (len1 + len2 - 1) / 2;
        double ans = 0;
        while (i < len1 && j < len2){
            curIdx++;
            if(nums1[i] <= nums2[j]){
                i++;
                if(curIdx == targetIdx){
                    ans= nums1[i - 1];
                    break;
                }
            }else {
                j++;
                if(curIdx == targetIdx){
                    ans = nums2[j-1];
                    break;
                }
            }
        }
        if(curIdx != targetIdx){
           while (i < len1){
               curIdx++;
               i++;
               if(curIdx == targetIdx){
                   ans = nums1[i-1];
                   break;
               }
           }

           while (j < len2){
               curIdx++;
               j++;
               if(curIdx ==  targetIdx){
                   ans = nums2[j-1];
                   break;
               }
           }
        }
        // 判断奇数个还是偶数个
        if((len1 + len2) % 2 == 0){
            //偶数
            double other = 0;
            if(i < len1 && j < len2){
                other = nums1[i] <= nums2[j] ? nums1[i] : nums2[j];
            }else if(i < len1 && j >= len2){
                other = nums1[i];
            }else if(i >= len1 && j < len2){
                other = nums2[j];
            }
            return (ans + other) / 2;
        }else {
            return ans;
        }
    }
}
