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
        // record[0] 起始位置 record[1] 结束位置
        int[] record = new int[2];
        for (int i = 0; i < str.length; i++) {
            i = findLongestParlindrome(str, record, i);
        }
        return s.substring(record[0], record[1] + 1);
    }

    private int findLongestParlindrome(char[] str, int[] record, int low) {
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        if (record[1] - record[0] < high - low) {
            record[0] = low;
            record[1] = high;
        }
        return ans;
    }


}
