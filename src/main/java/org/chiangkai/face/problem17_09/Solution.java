package org.chiangkai.face.problem17_09;

/**
 * @author ChiangKai
 * @date 2022/9/28
 */
public class Solution {

    private int p3, p5, p7;

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            int r3 = dp[p3] * 3;
            int r7 = dp[p7] * 7;
            int r5 = dp[p5] * 5;
            dp[i] = Math.min(r3, Math.min(r5, r7));
            if (dp[i] == r3) {
                p3++;
            }
            if (dp[i] == r5) {
                p5++;
            }
            if (dp[i] == r7) {
                p7++;
            }
        }
        return dp[k - 1];
    }
}
