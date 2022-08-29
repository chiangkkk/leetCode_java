package org.chiangkai.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {
    @Test
    public void testProblem3(){
        Solution solution = new Solution();
        int len= solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(len);
    }
}