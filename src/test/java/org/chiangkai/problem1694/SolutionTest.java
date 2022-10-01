package org.chiangkai.problem1694;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1694() {
        Solution solution = new Solution();
        String number = "";
        number = "123 4-5678";
        String s = solution.reformatNumber(number);
        System.out.println(s);
    }

}