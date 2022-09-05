package org.chiangkai.problem6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        //"PAYPALISHIRING"
        //4
        // "PINALSIGYAHRPI"
        // "PINALIGYAIHRNPI"
        String paypalishiring = solution.convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);
    }
}