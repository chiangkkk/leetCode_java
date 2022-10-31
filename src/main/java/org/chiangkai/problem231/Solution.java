package org.chiangkai.problem231;

/**
 *  2 的幂
 * @author ChiangKai
 * @date 2022/10/28
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }
}
