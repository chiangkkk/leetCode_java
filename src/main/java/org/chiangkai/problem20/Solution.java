package org.chiangkai.problem20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ChiangKai
 * @date 2022/10/27
 */
public class Solution {
    public static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                if (!stack.isEmpty()) {
                    Character remove = stack.removeLast();
                    if (!remove.equals(map.get(aChar))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                stack.add(aChar);
            }
        }
        return stack.isEmpty();
    }
}
