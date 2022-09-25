package org.chiangkai.problem788;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ChiangKai
 * @date 2022/9/25
 */
public class Solution {
    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    int[][][] memo = new int[5][2][2];
    List<Integer> digits = new ArrayList<Integer>();

    public int rotatedDigits(int n) {
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 2; ++j) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        int ans = dfs(0, 1, 0);
        return ans;
    }

    public int dfs(int pos, int bound, int diff) {
        // 退出条件
        if (pos == digits.size()) {
            return diff;
        }
        // 记忆化
        if (memo[pos][bound][diff] != -1) {
            return memo[pos][bound][diff];
        }

        int ret = 0;
        // 转移状态
        for (int i = 0; i <= (bound != 0 ? digits.get(pos) : 9); ++i) {
            if (check[i] != -1) {
                ret += dfs(
                        pos + 1,
                        bound != 0 && i == digits.get(pos) ? 1 : 0,
                        diff != 0 || check[i] == 1 ? 1 : 0
                );
            }
        }
        return memo[pos][bound][diff] = ret;
    }
}
