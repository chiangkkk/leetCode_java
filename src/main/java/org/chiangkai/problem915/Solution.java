package org.chiangkai.problem915;

/**
 * @author ChiangKai
 * @date 2022/10/24
 */
public class Solution {
    public int partitionDisjoint(int[] nums) {

        int[] minRight = new int[nums.length];
        int tempMin = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            tempMin = Math.min(nums[i], tempMin);
            minRight[i] = tempMin;
        }
        int tempMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            tempMax = Math.max(nums[i], tempMax);
            if (tempMax <= minRight[i + 1]) {
                return i + 1;
            }
        }
        return nums.length - 1;
    }
}
