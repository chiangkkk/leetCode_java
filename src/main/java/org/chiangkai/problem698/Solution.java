package org.chiangkai.problem698;

import java.util.Arrays;

/**
 * @author ChiangKai
 * @date 2022/9/20 10:54
 */
public class Solution {
    int nums[];
    int n; // 数组长度
    int k; // 分成k个数组
    int t; // 每个数组的和

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        this.nums = nums;
        this.k = k;
        if (sum % k != 0) {
            return false;
        }
        n = nums.length;
        t = sum / k;
        Arrays.sort(this.nums);
        return dfs(n - 1, 0, 0, new boolean[n]);
    }

    /**
     * 搜索函数
     *
     * @param idx 是搜索关键，其含义为搜索空间的分割点。
     *            即对于当前正在搜索的集合，我们不会每次都扫描整个 nums 来找添加到该集合的下一个元素，
     *            而是能够明确下一个元素必然在 idx 的左边或右边。
     * @param cur 为当前集合的元素和（初始值为 0）；
     * @param cut 是已凑成多少个总和为 t 的集合
     *            （初始值为 00，当 cnt = k 时，我们搜索到了合法方案，
     *            返回 true，否则对 cnt 进行加一操作，并将 cur 置零，搜索下个集合）；
     * @param vis 用于记录哪些 nums[i] 已被使用
     * @return
     */
    private boolean dfs(int idx, int cur, int cut, boolean[] vis) {
        // 当前集合元素个数等于目标集合个数
        if (cut == k) {
            return true;
        }
        // 当前集合和等于目标集合和
        if (cur == t) {
            return dfs(n - 1, 0, cut + 1, vis);
        }
        // 扫描到最后一个不存在解
        if (idx == -1) {
            return false;
        }
        for (int i = idx; i >= 0; i--) {
            // 当前数字已被用 当前搜索集合大于
            if (vis[i] || cur + nums[i] > t) {
                continue;
            }
            // 使用当前
            vis[i] = true;
            if (dfs(i - 1, cur + nums[i], cut, vis)) {
                return true;
            }
            vis[i] = false;
            // 前集合如果连第一个值都无法搜到
            if (cur == 0) {
                return false;
            }
        }
        return false;
    }
}
