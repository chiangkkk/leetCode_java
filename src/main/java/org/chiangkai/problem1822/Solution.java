package org.chiangkai.problem1822;

/**
 * @author ChiangKai
 * @date 2022/10/27
 */
public class Solution {
    public int arraySign(int[] nums) {
        boolean flag = true;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                flag = !flag;
            }
        }
        return flag ? 1 : -1;
    }
}
