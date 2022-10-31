package org.chiangkai.problem349;

import java.util.HashSet;

/**
 * 求两个数组的交集
 *
 * @author ChiangKai
 * @date 2022/10/31
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set
                = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        HashSet<Integer> res = new HashSet<>(set.size());
        for (int num : nums2) {
            if (set.contains(num)){
                res.add(num);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
