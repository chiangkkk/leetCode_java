package org.chiangkai.problem1652;

/**
 * @author ChiangKai
 * @date 2022/9/24
 */
public class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k != 0) {
            int[] rail = new int[code.length * 2];
            System.arraycopy(code, 0, rail, 0, code.length);
            System.arraycopy(code, 0, rail, code.length, code.length);
            int l, r;
            if (k > 0) {
                l = 1;
                r = k;
            } else {
                l = code.length + k;
                r = code.length - 1;
            }
            int slider = 0;
            for (int i = l; i <= r; i++) {
                slider += rail[i];
            }
            for (int i = 0; i < code.length; i++) {
                res[i] = slider;
                slider -= rail[l];
                l++;
                r++;
                slider += rail[r];
            }
        }
        return res;
    }
}
