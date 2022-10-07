package org.chiangkai.problem1800;

/**
 * @author ChiangKai
 * @date 2022/10/7
 */
class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0], temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp += nums[i];
                if (temp > res) {
                    res = temp;
                }
            } else {
                temp = nums[i];
            }
        }
        return res;
    }
}