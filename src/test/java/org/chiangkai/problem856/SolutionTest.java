package org.chiangkai.problem856;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test865(){
        Solution solution = new Solution();
        int i = solution.scoreOfParentheses("()()");
        System.out.println(i);
    }

}