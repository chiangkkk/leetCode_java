package org.chiangkai.problem1800;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test1800(){
        Solution solution = new Solution();
        int i = solution.maxAscendingSum(new int[]{12,17,15,13,10,11,12});
        System.out.println(i);
    }

}