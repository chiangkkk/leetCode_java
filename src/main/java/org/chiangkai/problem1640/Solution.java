package org.chiangkai.problem1640;

import java.util.HashMap;

/**
 * @author ChiangKai
 * @date 2022/9/22 8:45
 */
public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 记录每个数字的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int[] piece : pieces) {
            // 每个piece上一个的位置
            int lastPos = -1;
            for (int i = 0; i < piece.length; i++) {
                // piece 不包含 arr 中的数 ,根据 sum(pieces[i].length) == arr.length, 则无法组成arr
                if (!map.containsKey(piece[i])) {
                    return false;
                }
                Integer pos = map.get(piece[i]);
                // piece第一个不比较
                if (i != 0){
                    //piece中的上一个相邻的数字在arr中应该也是相邻的，不相邻则不符合条件
                    if (pos != lastPos+1){
                        return false;
                    }
                }
                lastPos = pos;
            }
        }
        return true;
    }
}
