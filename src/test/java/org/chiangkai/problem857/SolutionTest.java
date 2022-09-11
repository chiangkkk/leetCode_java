package org.chiangkai.problem857;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test857() {
        Solution solution = new Solution();
        double v = solution.mincostToHireWorkers(new int[]{10, 20, 5},
                new int[]{70, 50, 30}, 2);
        System.out.println(v);
    }

}