package org.chiangkai.problem5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test(){
        Solution solution = new Solution();
        String ccc = solution.longestPalindrome("ccc");
        System.out.println(ccc);
    }

}