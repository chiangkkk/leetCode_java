package org.chiangkai.problem647;

/**
 * @author ChiangKai
 * @date 2022/8/31 23:29
 */
class Solution {
    int num = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 0; i < s.length(); i++) {
            find(s, i, i);
            find(s, i, i + 1);
        }
        return num;
    }

    public void find(String s, int start, int end) {
        while (start > 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }
}