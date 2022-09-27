package org.chiangkai.face.problem01_02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test01_02() {
        Solution solution = new Solution();
        System.out.println(solution.CheckPermutation("abc", "bca"));
    }

}