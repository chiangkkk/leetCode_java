package org.chiangkai.problem904;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChiangKai
 * @date 2022/10/17
 */
public class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0, left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right] , 0)+1);
            while (map.size() == 3) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
