package org.chiangkai.problem5;

/**
 * @author ChiangKai
 * @date 2022/8/31 23:23
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        boolean isPalindrome[][] = new boolean[s.length()][s.length()];
        return null;
    }
}
