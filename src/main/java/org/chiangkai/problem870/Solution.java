package org.chiangkai.problem870;

import java.util.Arrays;

/**
 * 田忌赛马
 *
 * @author ChiangKai
 * @date 2022/10/8
 */
public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);
        int left = 0, right = n - 1;

        for (int i = 0; i < n; ++i) {
            // 如果nums1 最小的大于nums2 最小的
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                // nums2 最小的 对应 nums1 最小的
                result[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                // nums2 最大的 对应 nums1 最小的
                result[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }

        return result;
    }
}
