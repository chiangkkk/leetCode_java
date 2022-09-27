package org.chiangkai.face.problem01_02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            // 记录异或和  a⊗a=0 如果s1和s2一样 异或和 为 0
            int xor = 0;
            // 记录hash
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                xor ^= s1.charAt(i);
                map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            }
            for (int i = 0; i < s2.length(); i++) {
                xor ^= s2.charAt(i);
                if (!map.containsKey(s2.charAt(i))) {
                    return false;
                }
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            }
            // 存在 s1 = aa s2 = bb 的情况，用hash记录解决
            if (xor == 0) {
                for (Character character : map.keySet()) {
                    if (!map.get(character).equals(0)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}