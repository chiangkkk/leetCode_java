package org.chiangkai.problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChiangKai
 * @date 2022/8/20 22:02
 */
public class Solution {

    // 双向收敛
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // i <= j 解决用例 eg{3,2,4} 6
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            if (map.containsKey(target - nums[j])) {
                return new int[]{map.get(target - nums[j]), j};
            }
            map.put(nums[i], i);
            map.put(nums[j], j);
        }
        return new int[0];
    }
}
