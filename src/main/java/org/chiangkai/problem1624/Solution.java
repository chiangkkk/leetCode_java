package org.chiangkai.problem1624;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChiangKai
 * @date 2022/9/17 16:08
 */
public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        if(s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = -1;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                maxLen = Math.max(maxLen, i - map.get(c) - 1);
            }else{
                map.put(c, i);
            }
        }
        return maxLen;
    }


}
