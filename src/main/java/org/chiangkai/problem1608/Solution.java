package org.chiangkai.problem1608;

/**
 * @author ChiangKai
 * @date 2022/9/12 18:54
 */
public class Solution {
    public int specialArray(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            boolean flag = false;
            int count = 0;
            for (int num : nums) {
                if (num >= i) {
                    count++;
                    if (count > i) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                continue;
            }
            if (count == i) {
                return i;
            }
        }
        return -1;
    }
}
