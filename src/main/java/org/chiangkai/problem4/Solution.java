package org.chiangkai.problem4;

/**
 * @author ChiangKai
 * @date 2022/8/29 21:44
 */
class Solution {
    //TODO 没啥思路
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1 = nums1.length;
        int num2 = nums2.length;
        double result = 0.0;
        int i1 = 0;
        int i2 = 0;
        int now = 0;
        boolean flagNums1 = false;
        if ((num1 + num2) % 2 == 0) {
            int med = (num1 + num2) / 2;
            while (true) {
                if (nums1[i1] < nums2[i2]) {
                    i1++;
                    flagNums1 = true;
                } else {
                    i2++;
                    flagNums1 = false;
                }
                if (now+1 == med){
                    if (flagNums1){
                        result = 0; //有局限型
                    }else {

                    }
                }
                now++;
            }
        } else {
            int med = (num1 + num2) / 2 + 1;

            while (true) {
                if (nums1[i1] < nums2[i2]) {
                    i1++;
                    flagNums1 = true;
                } else {
                    i2++;
                    flagNums1 = false;
                }
                if (now + 1 == med) {
                    if (flagNums1) {
                        result = nums1[i1];
                    } else {
                        result = nums2[i2];
                    }
                    break;
                }
                now++;
            }
        }
        return result;
    }
}