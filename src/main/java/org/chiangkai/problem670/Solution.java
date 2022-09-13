package org.chiangkai.problem670;

import java.util.HashMap;

/**
 * @author ChiangKai
 * @date 2022/9/13 8:40
 */
class Solution {
    public int maximumSwap(int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] chars = (num + "").toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!map.containsKey((int) chars[i])) {
                map.put((int) chars[i], i);
            }
        }
        flag:
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = '9'; j > chars[i]; j--) {
                if (map.containsKey(j) && map.get(j) > i) {
                    swap(chars, i, map.get(j));
                    break flag;
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}