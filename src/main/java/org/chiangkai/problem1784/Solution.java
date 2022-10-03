package org.chiangkai.problem1784;

/**
 * @author ChiangKai
 * @date 2022/10/3
 */
public class Solution {
    public boolean checkOnesSegment(String s) {

        int l = 0, r = s.length() - 1;
        while (l < s.length() && s.charAt(l) == '1') {
            l++;
        }
        while (r >= 0 && s.charAt(r) == '0') {
            r--;
        }
        return l - r == 1;
    }
}
