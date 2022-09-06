package org.chiangkai.problem7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public  void test7(){
        Solution solution = new Solution();
        int reverse = solution.reverse(-123);
        System.out.println(reverse);
    }

}