package org.chiangkai.problem342;

/**
 * 是4 的幂
 * @author ChiangKai
 * @date 2022/10/28
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
