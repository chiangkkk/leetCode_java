package org.chiangkai.problem1619;

import java.util.Arrays;

/**
 * @author ChiangKai
 * @date 2022/9/14 8:55
 */
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double sum = 0;
        for (int i = arr.length / 20; i < 19 * arr.length / 20; i++) {
            sum += arr[i];
        }
        return sum / (arr.length * 9 / 10);
    }
}