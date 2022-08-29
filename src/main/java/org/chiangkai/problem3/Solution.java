package org.chiangkai.problem3;

import java.util.HashSet;

/**
 * @author ChiangKai
 * @date 2022/8/28 21:53
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxStrlen = 0;

        if (s.length() > 0) {
            if (s.length() == 1) {
                return 1;
            }
            int rp = 0;
            HashSet<Character> str = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (i != 0) {
                    str.remove(s.charAt(i - 1));
                }
                while (rp < s.length() && !str.contains(s.charAt(rp))) {
                    str.add(s.charAt(rp));
                    rp++;
                }
                maxStrlen = Math.max(str.size(), maxStrlen);
            }
        }
        return maxStrlen;
    }
}