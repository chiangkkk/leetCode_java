package org.chiangkai.problem1790;

/**
 * @author ChiangKai
 * @date 2022/10/11
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int pos1 = -1, pos2 = -1, xor = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (pos2 != -1) return false;
                if (pos1 != -1) {
                    pos2 = i;
                    if (!(s1.charAt(pos1) == s2.charAt(pos2) && s1.charAt(pos2) == s2.charAt(pos1)))
                        return false;
                }
                pos1 = i;
            }
            xor = xor ^ s1.charAt(i) ^ s2.charAt(i);
        }
        return xor == 0;
    }
}
