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
        char[] str = s.toCharArray();
        int maxLen = 0, start = 0, end = 0;
        boolean dp[][] = new boolean[str.length][str.length];
        for (int i = str.length - 1; i >= 0; i--) {
            for (int j = i; j < str.length; j++) {
                if (str[i] == str[j]) {
                    if (j - i == 0 || j - i == 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    end = j;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }

}
