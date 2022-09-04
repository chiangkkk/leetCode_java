package org.chiangkai.problem647;

/**
 * @author ChiangKai
 * @date 2022/8/31 23:29
 */
class Solution {
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        count++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}