package org.chiangkai.problem1636;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ChiangKai
 * @date 2022/9/19 8:38
 */
public class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        list.sort((x, y) -> {
            if (map.get(x).equals(map.get(y))) {
                return y - x;
            }
            return map.get(x) - map.get(y);
        });

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
