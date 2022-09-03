package org.chiangkai.problem4;

/**
 * @author ChiangKai
 * @date 2022/8/29 21:44
 */
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1 = nums1.length;
        int num2 = nums2.length;
        int countNum = num1 + num2;
        boolean isDouble = countNum % 2 != 1;
        int last = 0, result = 0, now1 = 0, now2 = 0;
        for (int i = 0; i <= countNum / 2; i++) {
            last = result;
            if (now1<num1 && now2 < num2) {
                if (nums1[now1] < nums2[now2]) {
                    result = nums1[now1];
                    now1++;
                } else {
                    result = nums2[now2];
                    now2++;
                }
            } else if (now1 == num1) {
                result = nums2[now2];
                now2++;
            } else {
                result = nums1[now1];
                now1++;
            }
        }
        if (isDouble) {
            // 遇到的 int/int = int 的坑
            return (result + last + 0.0) / 2;
        }
        return result;
    }
}