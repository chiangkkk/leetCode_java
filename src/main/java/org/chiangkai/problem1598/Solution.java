package org.chiangkai.problem1598;

/**
 * @author ChiangKai
 * @date 2022/9/9 21:27
 */
public class Solution {

    public int minOperations(String[] logs) {
        int deep = 0;
        for (String log : logs) {
            if ("./".equals(log)) continue;
            if ("../".equals(log)) {
                deep = deep > 0 ? --deep : 0;
                continue;
            }
            deep++;
        }
        return deep;
    }
}
