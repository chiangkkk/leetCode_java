package org.chiangkai.problem856;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ChiangKai
 * @date 2022/10/9
 */
public class Solution {

    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<Integer>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }


}
